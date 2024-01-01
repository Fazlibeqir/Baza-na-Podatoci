import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Costumer} from "../model/costumer";
import {catchError, tap, throwError} from "rxjs";
import {Publisher} from "../model/Publisher";
import {Platform} from "../model/Platform";
import {Promotion} from "../model/promotion";
import {Payment} from "../model/payment";

@Injectable({
  providedIn: 'root'
})
export class EntityService {
  httpOptions={
    headers:new HttpHeaders({"Content-Type":"application/json"}),
    responseType:'text' as 'json'
  };
  private baseUrl=environment.apiUrl+"entity";
  constructor(private http:HttpClient) { }

  addCostumer(costumer:Costumer){
    return this.http.post<any>(`${this.baseUrl}/costumer/add`,costumer,this.httpOptions)
      .pipe(
        tap(response => console.log(response)),
          catchError(error =>{
            console.error(error);
            const errorMessage=error.error?error.error:'Server error';
            return throwError(errorMessage);
          }));}

  addPublisher(publisher:Publisher){
    return this.http.post<any>(`${this.baseUrl}/publisher/add`,publisher,this.httpOptions)
      .pipe(
        tap(response => console.log(response)),
        catchError(error =>{
          console.error(error);
          const errorMessage=error.error?error.error:'Server error';
          return throwError(errorMessage);
        }));}
  addPlatform(platform:Platform){
    return this.http.post<any>(`${this.baseUrl}/platform/add`,platform,this.httpOptions)
      .pipe(
        tap(response => console.log(response)),
        catchError(error =>{
          console.error(error);
          const errorMessage=error.error?error.error:'Server error';
          return throwError(errorMessage);
        }));}
    addPromotion(promotion:Promotion){
    return this.http.post<any>(`${this.baseUrl}/promotion/add`,promotion,this.httpOptions)
      .pipe(
        tap(response => console.log(response)),
        catchError(error =>{
          console.error(error);
          const errorMessage=error.error?error.error:'Server error';
          return throwError(errorMessage);
        }));}
    addPayment(payment:Payment){
    return this.http.post<any>(`${this.baseUrl}/payment/add`,payment,this.httpOptions)
      .pipe(
        tap(response => console.log(response)),
        catchError(error =>{
          console.error(error);
          const errorMessage=error.error?error.error:'Server error';
          return throwError(errorMessage);
        }));}

}
