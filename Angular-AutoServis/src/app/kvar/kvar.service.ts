import { Injectable } from '@angular/core';
import { Kvar } from './kvar.model';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { SERVER_API_URL } from '../constants/app.constants';

@Injectable({
  providedIn: 'root'
})
export class KvarService {

  private kvaroviUrl = `${SERVER_API_URL}/api/v1/kvarovi`;

  constructor(
    private http: HttpClient
  ) { }

  getKvarovi(): Observable<Kvar[]> {
    return this.http.get<Kvar[]>(this.kvaroviUrl)
      .pipe(
        tap(_ => console.log('fetched kvarovi')),
        catchError(this.handleError<Kvar[]>('getKvarovi', []))
      );
  }

  getKvar(id: number): Observable<Kvar> {
    const url = `${this.kvaroviUrl}/${id}`;
    return this.http.get<Kvar>(url)
      .pipe(
        tap(_ => console.log(`fetched kvar id=${id}`)),
        catchError(this.handleError<Kvar>(`getKvar id=${id}`))
      );
  }

  updateKvar(kvar: Kvar): Observable<any> {
    const url = `${this.kvaroviUrl}/${kvar.id}`;
    return this.http.put(url, kvar).pipe(
      tap(_ => console.log(`updated kvar id=${kvar.id}`)),
      catchError(this.handleError<any>('updateKvar'))
    );
  }

  addKvar(kvar: Kvar): Observable<Kvar> {
    return this.http.post<Kvar>(this.kvaroviUrl, kvar).pipe(
      tap((newKvar: Kvar) => console.log(`added kvar w/ id=${newKvar.id}`)),
      catchError(this.handleError<Kvar>('addKvar'))
    );
  }

  /*deleteKvar(kvar: Kvar | number): Observable<Kvar> {
    const id = typeof kvar === 'number' ? kvar : kvar.id;
    const url = `${this.kvaroviUrl}/${id}`;

    return this.http.delete<Kvar>(url).pipe(
      tap(_ => console.log(`deleted kvar id=${id}`)),
      catchError(this.handleError<Kvar>('deleteKvar'))
    );
  }
  */

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

}
