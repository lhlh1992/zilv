import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SystemManageDicitemComponent } from './dicitem/dicitem.component';
import { SystemManageUserComponent } from './user/user.component';
import { SystemManageRoleComponent } from './role/role.component';
import { SystemManagePremComponent } from './prem/prem.component';


const routes: Routes = [

 
  { path: 'dicitem', component: SystemManageDicitemComponent },
  { path: 'user', component: SystemManageUserComponent },
  { path: 'role', component: SystemManageRoleComponent },
  { path: 'prem', component: SystemManagePremComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemManageRoutingModule { }
