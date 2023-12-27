import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import {StoreViewService} from "./services/viewService/StoreView.service";
import {StoreViewComponent} from "./views/storeView/StoreView.component";
import { UserLibraryViewComponent } from './views/userLibraryView/UserLibraryView.component';
import { GameReviewsComponent } from './views/GameReviews/GameReviews.component';
import {UserLibraryViewService} from "./services/viewService/UserLibraryView.service";
import {GameReviewsService} from "./services/viewService/GameReviews.service";
import { ReportsComponent } from './views/reports/reports.component';
import { GameFromComponent } from './forms/game-from/game-from.component';
import {ReactiveFormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSnackBarModule} from "@angular/material/snack-bar";


@NgModule({
  declarations: [
    AppComponent,
    StoreViewComponent,
    UserLibraryViewComponent,
    GameReviewsComponent,
    ReportsComponent,
    GameFromComponent
  ],
  imports: [
    MatSnackBarModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [StoreViewService,UserLibraryViewService,GameReviewsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
