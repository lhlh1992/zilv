import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { Router} from '@angular/router';
import { ServicesService} from '../../../services/services.service';

@Component({
  selector: 'app-guanli-guanli-page',
  templateUrl: './guanli-page.component.html',
  styleUrls: ['./guanli-page.component.css']
})
export class GuanliGuanliPageComponent implements OnInit {
  data:any[]=[]; //列表数据
  isVisible=false;//新增修改弹出框开关
  laydate : any; 
  selectedValue = new Date('2019-03-25');
  
  @ViewChild('st') st: STComponent;
  columns: STColumn[] = [
    { title: '日期', index: 'create_time' },
  
   
    {
      title: '',
      buttons: [
        // { text: '查看', click: (item: any) => `/form/${item.id}` },
        // { text: '编辑', type: 'static', component: FormEditComponent, click: 'reload' },
      ]
    }
  ];

  constructor(private http: _HttpClient, private modal: ModalHelper,private router: Router,private config:ServicesService) { }

  ngOnInit() {
         this.query();
       
     
   }
  jumpHandle(ele){
    //这是在html中绑定的click跳转事件
    this.router.navigate(['/guanli/view'], {
        queryParams: {
           
            date: ele
        }
    });
  }

  query(){
       this.http.post(this.config.url+'Diary/selectDiary',
       {'name':''}
       ) .subscribe((res: any) => {
                  console.log(res)
                  this.data=res;
        
   });
       
  }


    //新增字典类型打开模态框
    add(){
      this.isVisible = true;

    }
    handleCancel(){
      this.isVisible = false;
    }


    onChange(result: Date): void {
      console.log('onChange: ', result);
    }

    getMonthData(date: Date): number | null {
      if (date.getMonth() === 8) {
        return 1394;
      }
      return null;
    }


    nzPanelChange(){
          alert('ddd');
    }


    selectChange(select: Date): void {
     // console.log(`Select value: ${select}`);
     
    // this.jumpHandle(select)
    }



       //键盘回车事件
   keydown(data){
    if (data.keyCode === 13) {
      this.query();
    }
  }


}
