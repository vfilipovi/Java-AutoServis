import { Injectable } from '@angular/core';
import { Radnik } from './radnik.model';
import { Observable, of, pipe } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { SERVER_API_URL } from '../constants/app.constants';

@Injectable ({
  providedIn: 'root'
})
export class RadnikService {
  private radniciUrl = `${SERVER_API_URL}/radnici`;

  constructor(
    private http: HttpClient
  ) {}

  getRadnici(): Observable<Radnik[]> {
    return this.http.get<Radnik[]>(this.radniciUrl)
      .pipe(
        tap(_ => console.log('fetched radnici')),
        catchError(this.handleError<Radnik[]>('getRadnici', []))
      );
  }
  getRadnik(id: string): Observable<Radnik> {
    const url = `${this.radniciUrl}/${id}`;
    return this.http.get<Radnik>(url)
      .pipe(
        tap(_ => console.log(`fetched radnik id=${id}`)),
        catchError(this.handleError<Radnik>(`getRadnik id=${id}`))
      );
  }
  updateRadnik(radnik: Radnik): Observable<any> {
    const url = `${this.radniciUrl}/$(radnik.id)`;
    return this.http.put(url, radnik)
      .pipe(
        tap(_ => console.log('updated radnik id=${radnik.id}')),
        catchError(this.handleError<any>('updateRadnik'))
      );
  }
  addRadnik (radnik: Radnik): Observable<Radnik> {
    return this.http.post<Radnik>(this.radniciUrl, radnik).pipe(
        tap((newRadnik: Radnik) => console.log(`added radnik=${newRadnik.id}`)),
        catchError(this.handleError<Radnik>('addRadnik'))
      );
  }
  deleteRadnik(radnik: Radnik | string): Observable<Radnik> {
    const id = typeof radnik === 'string' ? radnik : radnik.id;
    const url = `${this.radniciUrl}/${id}`;

    return this.http.delete<Radnik>(url).pipe(
        tap(_ => console.log(`deleted radnik id=${id}`)),
        catchError(this.handleError<Radnik>('deleteRadnik'))
      );
  }

  private handleError<param>(operation = 'operation', result?: param) {
    return (error: any): Observable<param> => {
      console.error(operation);
      console.error(error);
      return of(result as param);
    };
  }
}
