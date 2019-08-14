import { NgModule } from '@angular/core';
import { SharedModule } from '@shared';
import { SystemManageRoutingModule } from './system-manage-routing.module';
import { SystemManageDicitemComponent } from './dicitem/dicitem.component';
import { SystemManageUserComponent } from './user/user.component';
import { SystemManageRoleComponent } from './role/role.component';
import { SystemManagePremComponent } from './prem/prem.component';


const COMPONENTS = [
 
  SystemManageDicitemComponent,
  SystemManageUserComponent,
  SystemManageRoleComponent,
  SystemManagePremComponent];
const COMPONENTS_NOROUNT = [];

@NgModule({
  imports: [
    SharedModule,
    SystemManageRoutingModule
  ],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT
  ],
  entryComponents: COMPONENTS_NOROUNT
})
export class SystemManageModule { }
