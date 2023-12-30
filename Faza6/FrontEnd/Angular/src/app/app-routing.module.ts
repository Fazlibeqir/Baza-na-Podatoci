import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreViewComponent } from "./views/storeView/StoreView.component";
import {OrderViewComponent} from "./views/orderView/OrderView.component";
import {GameReviewsComponent} from "./views/GameReviews/GameReviews.component";
import {ReportsComponent} from "./views/reports/reports.component";
import {GameFromComponent} from "./forms/game-from/game-from.component";
import {ReviewFormComponent} from "./forms/review-form/review-form.component";
const routes: Routes = [
  {
    path: '',
    redirectTo: 'games',
    pathMatch: 'full'
  },
  {
    path: 'games',
    component: StoreViewComponent
  },
    {
      path: 'orders',
      component: OrderViewComponent
    },
  {
    path:'Reviews',
    component: GameReviewsComponent
  },
  {
    path: 'Reports',
    component: ReportsComponent
  },
  {
    path:'game-form',
    component:GameFromComponent
  },
  {
    path:'review-form',
    component:ReviewFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
