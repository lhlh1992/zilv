import { NgModule } from '@angular/core';
import { SharedModule } from '@shared';
import { SystemManageRoutingModule } from './system-manage-routing.module';
import { SystemManageDicitemComponent } from './dicitem/dicitem.component';
import { SystemManageUserComponent } from './user/user.component';


const COMPONENTS = [
 
  SystemManageDicitemComponent,
  SystemManageUserComponent];
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
