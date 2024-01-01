import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {catchError, Observable, tap, throwError} from "rxjs";
import Big from "big.js";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  httpOptions={
    headers:new HttpHeaders({"Content-Type":"application/json"}),
    responseType:'text' as 'json'
  };
  private baseUrl=environment.apiUrl+"order";

  constructor(
    private http:HttpClient,
  ){}
  getCostumers(){
    return this.http.get<any>(`${this.baseUrl}/costumers`);
  }
  getPayments(){
    return this.http.get<any>(`${this.baseUrl}/payments`);
  }

  insertOrder(status:string,orderDate:Date,totalAmount:Big,idCostumer:number,idPayment:number,idGames:number[],idPromotions:number[]):Observable<any>{
    const orderData={
      status,
      orderDate,
      totalAmount,
      idCostumer,
      idPayment,
      idGame: idGames,
      idPromotion:idPromotions
    };
    return this.http.post<any>(`${this.baseUrl}/add`,orderData,this.httpOptions)
      .pipe(
        tap(response => console.log(response)),
        catchError(error => {
          console.error(error);
          const errorMessage = error.error ? error.error : 'Server error';
          return throwError(errorMessage);}));

  }
}
