import { Injectable } from '@angular/core';
import {HttpHeaders,HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class GameReviewsService {
  httpOptions={
    headers:new HttpHeaders({"Content-Type":"application/json"}),
  };
  private baseUrl=environment.apiUrl+"Reviews";
  constructor(
    private http:HttpClient,
  ){}
  getAllGameReviews():Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }
}
