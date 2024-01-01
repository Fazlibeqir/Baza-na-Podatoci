import { Component } from '@angular/core';
// import {SharedService} from "./services/sharedService/shared.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title="Online Game Shop";
  searchTerm:string='';
  constructor(
   // private sharedService:SharedService
  ){}

  // search():void{
  //   this.sharedService.setSearchTerm(this.searchTerm);
  // }
}
