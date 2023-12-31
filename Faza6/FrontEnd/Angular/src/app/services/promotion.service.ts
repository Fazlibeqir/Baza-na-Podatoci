import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PromotionService {
  httpOptions={
    headers:new HttpHeaders({"Content-Type":"application/json"}),
  };
  private baseUrl=environment.apiUrl+"promotion";
  constructor(private http:HttpClient) { }
  getPromotions():Observable<any>{
    return this.http.get<any>(`${this.baseUrl}/all`);
  }
}
