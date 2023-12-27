import { Injectable } from '@angular/core';
import {HttpHeaders,HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ReportsService {
  httpOptions ={
    headers:new HttpHeaders({"Content-Type":"application/json"}),
  };
  private baseUrl=environment.apiUrl+"reports";
  constructor( private http:HttpClient) { }
  getWeekly():Observable<any>{
    return this.http.get(`${this.baseUrl}`+"/weeklyReport");
  }
  getMonthly():Observable<any>{
    return this.http.get(`${this.baseUrl}`+"/monthlyReport");
  }
  getYearly():Observable<any>{
    return this.http.get(`${this.baseUrl}`+"/yearlyReport");
  }
}
