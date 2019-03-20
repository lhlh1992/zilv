import { NgModule } from '@angular/core';
import { SharedModule } from '@shared';
import { GuanliRoutingModule } from './guanli-routing.module';
import { GuanliGuanliPageComponent } from './guanli-page/guanli-page.component';
import { GuanliViewComponent } from './view/view.component';





const COMPONENTS = [
  
  GuanliGuanliPageComponent,
  GuanliViewComponent];
const COMPONENTS_NOROUNT = [
  
  ];

@NgModule({
  imports: [
    SharedModule,
    GuanliRoutingModule
  ],
  declarations: [
    ...COMPONENTS,
    ...COMPONENTS_NOROUNT
  ],
  entryComponents: COMPONENTS_NOROUNT
})
export class GuanliModule { }
