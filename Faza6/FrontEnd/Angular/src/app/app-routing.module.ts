import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreViewComponent } from "./views/StoreView.component";
const routes: Routes = [
  {
    path: 'games',
    component: StoreViewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
