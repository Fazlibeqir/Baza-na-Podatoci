import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import {StoreViewService} from "./services/StoreView.service";
import {StoreViewComponent} from "./views/storeView/StoreView.component";
import { UserLibraryViewComponent } from './views/userLibraryView/UserLibraryView.component';
import { GameReviewsComponent } from './views/GameReviews/GameReviews.component';
import {UserLibraryViewService} from "./services/UserLibraryView.service";
import {GameReviewsService} from "./services/GameReviews.service";


@NgModule({
  declarations: [
    AppComponent,
    StoreViewComponent,
    UserLibraryViewComponent,
    GameReviewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [StoreViewService,UserLibraryViewService,GameReviewsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
