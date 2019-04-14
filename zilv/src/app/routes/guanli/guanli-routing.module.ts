import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GuanliGuanliPageComponent } from './guanli-page/guanli-page.component';
import { GuanliViewComponent } from './view/view.component';
import { GuanliDetailsComponent } from './details/details.component';



const routes: Routes = [

  
  { path: 'guanliPage', component: GuanliGuanliPageComponent },
 
  { path: 'view', component: GuanliViewComponent },
  { path: 'details', component: GuanliDetailsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GuanliRoutingModule { }
