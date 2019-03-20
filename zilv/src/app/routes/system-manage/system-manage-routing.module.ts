import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SystemManageDicitemComponent } from './dicitem/dicitem.component';


const routes: Routes = [

 
  { path: 'dicitem', component: SystemManageDicitemComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemManageRoutingModule { }
