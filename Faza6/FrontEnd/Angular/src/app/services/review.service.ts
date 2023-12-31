import { Injectable } from '@angular/core';
import {catchError, Observable, tap, throwError} from "rxjs";
import {environment} from "../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Game} from "../model/game";

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  httpOptions={
    headers:new HttpHeaders({"Content-Type":"application/json"}),
    responseType:'text' as 'json'
  };
  private baseUrl=environment.apiUrl+"review";
  constructor(
    private http:HttpClient,
  ){}
  getGames():Observable<Game[]>{
    return this.http.get<Game[]>(`${this.baseUrl}/games`);
  }
  getCostumers():Observable<any>{
    return this.http.get<any>(`${this.baseUrl}/costumers`);
  }

  insertReview(rating:number,comment:string,idCostumer:number,idGame:number):Observable<any>{
    const reviewData={
      rating,
      comment,
      idCostumer,
      idGame
    };
    return this.http.post<any>(`${this.baseUrl}/add`,reviewData,this.httpOptions)
      .pipe(
        tap(response => console.log(response)),
        catchError(error => {
          console.error(error);
          const errorMessage = error.error ? error.error : 'Server error';
          return throwError(errorMessage);
        }));
  }
}
