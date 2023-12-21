import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import {StoreViewService} from "./services/StoreView.service";
import {StoreViewComponent} from "./views/StoreView.component";


@NgModule({
  declarations: [
    AppComponent,
    StoreViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [StoreViewService],
  bootstrap: [AppComponent]
})
export class AppModule { }
