import {Injectable} from '@angular/core';
import {HttpHeaders,HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from 'src/environments/environment';

@Injectable({
    providedIn:'root'
})
export class StoreViewService{
    httpOptions={
        headers:new HttpHeaders({"Content-Type":"application/json"}),
    };
    private baseUrl=environment.apiUrl+"games";
    constructor(
        private http:HttpClient,
    ){}
    getAllStoreView():Observable<any>{
        return this.http.get(`${this.baseUrl}`);
    }

}
