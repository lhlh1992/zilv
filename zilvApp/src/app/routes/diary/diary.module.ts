import { NgModule } from '@angular/core';
import { SharedModule } from '@shared';
import { DiaryRoutingModule } from './diary-routing.module';
import { GuanliGuanliPageComponent } from './guanli-page/guanli-page.component';
import { GuanliViewComponent } from './view/view.component';
import { GuanliDetailsComponent } from './details/details.component';
import { NgxEchartsModule } from 'ngx-echarts';

const COMPONENTS = [GuanliGuanliPageComponent, GuanliViewComponent, GuanliDetailsComponent];
const COMPONENTS_NOROUNT = [];

@NgModule({
  imports: [SharedModule, DiaryRoutingModule, NgxEchartsModule],
  declarations: [...COMPONENTS, ...COMPONENTS_NOROUNT],
  entryComponents: COMPONENTS_NOROUNT,
})
export class DiaryModule {}
