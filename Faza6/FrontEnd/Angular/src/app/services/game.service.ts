import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, tap, throwError} from "rxjs";
import {environment} from "../../environments/environment";
import Big from "big.js";
import {Publisher} from "../model/Publisher";
import {Platform} from "../model/Platform";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  httpOptions={
    headers:new HttpHeaders({"Content-Type":"application/json"}),
    responseType:'text' as 'json'
  };
  private baseUrl=environment.apiUrl+"game";
  constructor(private http:HttpClient) { }
  getGames():Observable<any>{
    return this.http.get<any>(`${this.baseUrl}/all`);
  }

    getPublishers():Observable<Publisher[]>{
        return this.http.get<Publisher[]>(`${this.baseUrl}/publishers`);
    }
    getPlatforms():Observable<Platform[]>{
      return this.http.get<Platform[]>(`${this.baseUrl}/platforms`);
    }
    insertGame(
    title:string,
    genre:string,
    image:string,
    price:Big,
    developer: string,
    stock: number,
    releaseDate: string,
    idPublisher:number,
    idPlatform:number
  ):Observable<any>{
    const gameData={
      title,
      genre,
      image,
      price,
      developer,
      stock,
      releaseDate,
      idPublisher,
      idPlatform
    };
    return this.http.post<any>(`${this.baseUrl}/add`,gameData,this.httpOptions)
      .pipe(
      tap(response => console.log(response)),
      catchError(error => {
        console.error(error);
        const errorMessage = error.error ? error.error : 'Server error';
        return throwError(errorMessage);})
    );
  }
}
