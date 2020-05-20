import { Injectable } from '@angular/core';
import { Klijent } from './klijent.model';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { SERVER_API_URL } from '../constants/app.constants';

@Injectable({
  providedIn: 'root'
})
export class KlijentService {

  private klijentiUrl = `${SERVER_API_URL}/klijenti`;

  constructor(
    private http: HttpClient
  ) { }

  getKlijenti(): Observable<Klijent[]> {
    return this.http.get<Klijent[]>(this.klijentiUrl)
      .pipe(
        tap(_ => console.log('fetched klijenti')),
        catchError(this.handleError<Klijent[]>('getKlijenti', []))
      );
  }

  getKlijent(id: string): Observable<Klijent> {
    const url = `${this.klijentiUrl}/${id}`;
    return this.http.get<Klijent>(url)
      .pipe(
        tap(_ => console.log(`fetched klijent id=${id}`)),
        catchError(this.handleError<Klijent>(`getKlijent id=${id}`))
      );
  }

  updateKlijent(klijent: Klijent): Observable<any> {
    const url = `${this.klijentiUrl}/${klijent.id}`;
    return this.http.put(url, klijent).pipe(
      tap(_ => console.log(`updated klijent id=${klijent.id}`)),
      catchError(this.handleError<any>('updateKlijent'))
    );
  }

  addKlijent(klijent: Klijent): Observable<Klijent> {
    return this.http.post<Klijent>(this.klijentiUrl, klijent).pipe(
      tap((newKlijent: Klijent) => console.log(`added klijent=${newKlijent.id}`)),
      catchError(this.handleError<Klijent>('addKlijent'))
    );
  }

  deleteKlijent(klijent: Klijent | string): Observable<Klijent> {
    const id = typeof klijent === 'string' ? klijent : klijent.id;
    const url = `${this.klijentiUrl}/${id}`;

    return this.http.delete<Klijent>(url).pipe(
      tap(_ => console.log(`deleted klijent id=${id}`)),
      catchError(this.handleError<Klijent>('deleteKlijent'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }

}
