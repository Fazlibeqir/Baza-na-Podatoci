// import { Injectable } from '@angular/core';
// import {BehaviorSubject, Observable} from "rxjs";
//
// @Injectable({
//   providedIn: 'root'
// })
// export class SharedService {
//   private searchTermMain=new BehaviorSubject<string>('');
//   searchTerm$:Observable<string>=this.searchTermMain.asObservable();
//
//   setSearchTerm(searchTerm:string):void{
//     this.searchTermMain.next(searchTerm);
//   }
//   getSearchTerm():string{
//     return this.searchTermMain.value;
//   }
// }
