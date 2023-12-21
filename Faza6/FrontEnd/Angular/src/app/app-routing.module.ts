import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreViewComponent } from "./views/storeView/StoreView.component";
import {UserLibraryViewComponent} from "./views/userLibraryView/UserLibraryView.component";
const routes: Routes = [
  {
    path: 'games',
    component: StoreViewComponent
  },
    {
      path: 'library',
      component: UserLibraryViewComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
