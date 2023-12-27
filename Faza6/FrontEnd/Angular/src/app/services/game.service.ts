import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, tap, throwError} from "rxjs";
import {environment} from "../../environments/environment";
import Big from "big.js";
@Injectable({
  providedIn: 'root'
})
export class GameService {
  private baseUrl=environment.apiUrl+"game";
  constructor(private http:HttpClient) { }

  insertGame(
    title:string,
    genre:string,
    price:Big,
    developer: string,
    stock: number,
    releaseDate: string,
    idPublisher:number
  ):Observable<any>{
    const gameData={
      title,
      genre,
      price,
      developer,
      stock,
      releaseDate,
      idPublisher
    };
    return this.http.post<any>(`${this.baseUrl}/add`,gameData,{responseType:'text' as 'json'})
      .pipe(
      tap(response => console.log(response)),
      catchError(error => {
        console.error(error);
        return throwError(() => new Observable<never>());
      })
    );
  }
}
