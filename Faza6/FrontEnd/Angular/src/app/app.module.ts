import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import {StoreViewService} from "./services/viewService/StoreView.service";
import {StoreViewComponent} from "./views/storeView/StoreView.component";
import { OrderViewComponent } from './views/orderView/OrderView.component';
import { GameReviewsComponent } from './views/GameReviews/GameReviews.component';
import {UserLibraryViewService} from "./services/viewService/UserLibraryView.service";
import {GameReviewsService} from "./services/viewService/GameReviews.service";
import { ReportsComponent } from './views/reports/reports.component';
import {GameFromComponent} from './forms/game-from/game-from.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatToolbarModule} from "@angular/material/toolbar";
import { ReviewFormComponent } from './forms/review-form/review-form.component';
import { OrderFormComponent } from './forms/order-form/order-form.component';
import { EntityFormsComponent } from './forms/entity-forms/entity-forms.component';


@NgModule({
  declarations: [
    AppComponent,
    StoreViewComponent,
    OrderViewComponent,
    GameReviewsComponent,
    ReportsComponent,
    GameFromComponent,
    ReviewFormComponent,
    OrderFormComponent,
    EntityFormsComponent
  ],
  imports: [
    MatSnackBarModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    FormsModule
  ],
  providers: [StoreViewService,UserLibraryViewService,GameReviewsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
