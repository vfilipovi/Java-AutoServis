import { Injectable } from '@angular/core';
import { Mjesto } from './mjesto.model';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { SERVER_API_URL } from '../constants/app.constants';

@Injectable({
  providedIn: 'root'
})
export class MjestoService {

  private mjestaUrl = `${SERVER_API_URL}/mjesta`;

  constructor(
    private http: HttpClient
  ) { }

  getMjesta(): Observable<Mjesto[]> {
    return this.http.get<Mjesto[]>(this.mjestaUrl)
      .pipe(
        tap(_ => console.log('fetched mjesta')),
        catchError(this.handleError<Mjesto[]>('getMjesta', []))
      );
  }

  getMjesto(id: string): Observable<Mjesto> {
    const url = `${this.mjestaUrl}/${id}`;
    return this.http.get<Mjesto>(url)
      .pipe(
        tap(_ => console.log(`fetched mjesto id=${id}`)),
        catchError(this.handleError<Mjesto>(`getMjesto id=${id}`))
      );
  }

  updateMjesto(mjesto: Mjesto): Observable<any> {
    const url = `${this.mjestaUrl}/${mjesto.id}`;
    return this.http.put(url, mjesto).pipe(
      tap(_ => console.log(`updated mjesto id=${mjesto.id}`)),
      catchError(this.handleError<any>('updateMjesto'))
    );
  }

  addMjesto(mjesto: Mjesto): Observable<Mjesto> {
    return this.http.post<Mjesto>(this.mjestaUrl, mjesto).pipe(
      tap((newMjesto: Mjesto) => console.log(`added mjesto=${newMjesto.id}`)),
      catchError(this.handleError<Mjesto>('addMjesto'))
    );
  }

  deleteMjesto(mjesto: Mjesto | string): Observable<Mjesto> {
    const id = typeof mjesto === 'string' ? mjesto : mjesto.id;
    const url = `${this.mjestaUrl}/${id}`;

    return this.http.delete<Mjesto>(url).pipe(
      tap(_ => console.log(`deleted mjesto id=${id}`)),
      catchError(this.handleError<Mjesto>('deleteMjesto'))
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
