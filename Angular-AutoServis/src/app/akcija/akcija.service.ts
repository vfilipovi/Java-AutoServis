import { Injectable } from '@angular/core';
import { Akcija } from './akcija.model';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { SERVER_API_URL } from '../constants/app.constants';

@Injectable({
  providedIn: 'root'
})
export class AkcijaService {

  private akcijaUrl = `${SERVER_API_URL}/akcija`;

  constructor(
    private http: HttpClient
  ) { }

  getAkcija(): Observable<Akcija> {
    return this.http.get<Akcija>(this.akcijaUrl)
      .pipe(
        tap(_ => console.log('fetched akcija')),
        catchError(this.handleError<Akcija>('getAkcija'))
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
