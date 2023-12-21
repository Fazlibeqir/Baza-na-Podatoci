import {Injectable} from "@angular/core";
import {HttpHeaders,HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserLibraryView} from "../model/UserLibraryView";
import {environment} from "../../environments/environment";

@Injectable({
    providedIn:'root'
})
export class UserLibraryViewService{
    httpOptions={
        headers:new HttpHeaders({"Content-Type":"application/json"}),
    };
    private baseUrl=environment.apiUrl+"library";
    constructor(
        private http:HttpClient,
    ){}
    getAllUserLibraryView():Observable<any>{
        return this.http.get(`${this.baseUrl}`);
    }

}













