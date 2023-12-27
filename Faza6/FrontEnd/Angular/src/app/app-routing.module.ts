import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreViewComponent } from "./views/storeView/StoreView.component";
import {UserLibraryViewComponent} from "./views/userLibraryView/UserLibraryView.component";
import {GameReviewsComponent} from "./views/GameReviews/GameReviews.component";
import {ReportsComponent} from "./reports/reports/reports.component";
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
      path: 'library',
      component: UserLibraryViewComponent
    },
  {
    path:'Reviews',
    component: GameReviewsComponent
  }
  ,
  {
    path: 'Reports',
    component: ReportsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
