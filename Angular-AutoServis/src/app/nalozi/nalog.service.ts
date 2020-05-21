import { Injectable } from '@angular/core';
import { Nalog } from './nalog.model';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { SERVER_API_URL } from '../constants/app.constants';

@Injectable({
  providedIn: 'root'
})
export class NalogService {

  private naloziUrl = `${SERVER_API_URL}/nalozi`;

  constructor(
    private http: HttpClient
  ) { }

  getNalozi(): Observable<Nalog[]> {
    return this.http.get<Nalog[]>(this.naloziUrl)
      .pipe(
        tap(_ => console.log('fetched nalozi')),
        catchError(this.handleError<Nalog[]>('getNalozi', []))
      );
  }

  getNalog(id: string): Observable<Nalog> {
    const url = `${this.naloziUrl}/${id}`;
    return this.http.get<Nalog>(url)
      .pipe(
        tap(_ => console.log(`fetched nalog id=${id}`)),
        catchError(this.handleError<Nalog>(`getNalog id=${id}`))
      );
  }

  updateNalog(nalog: Nalog): Observable<any> {
    const url = `${this.naloziUrl}/${nalog.id}`;
    return this.http.put(url, nalog).pipe(
      tap(_ => console.log(`updated nalog id=${nalog.id}`)),
      catchError(this.handleError<any>('updateNalog'))
    );
  }

  addNalog(nalog: Nalog): Observable<Nalog> {
    return this.http.post<Nalog>(this.naloziUrl, nalog).pipe(
      tap((newNalog: Nalog) => console.log(`added nalog id=${newNalog.id}`)),
      catchError(this.handleError<Nalog>('addNalog'))
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
