import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GuanliGuanliPageComponent } from './guanli-page/guanli-page.component';
import { GuanliViewComponent } from './view/view.component';



const routes: Routes = [

  
  { path: 'guanliPage', component: GuanliGuanliPageComponent },
 
  { path: 'view', component: GuanliViewComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GuanliRoutingModule { }
