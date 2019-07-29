import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SystemManageDicitemComponent } from './dicitem/dicitem.component';
import { SystemManageUserComponent } from './user/user.component';


const routes: Routes = [

 
  { path: 'dicitem', component: SystemManageDicitemComponent },
  { path: 'user', component: SystemManageUserComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemManageRoutingModule { }
