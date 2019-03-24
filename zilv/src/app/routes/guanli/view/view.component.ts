import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-guanli-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class GuanliViewComponent implements OnInit {
  dateTime=''
  sportsData:any[]=[];//运动项目表数据
  isVisibleSports = false;
  url = `/user`;
  searchSchema: SFSchema = {
    properties: {
      no: {
        type: 'string',
        title: '编号'
      }
    }
  };

  
  @ViewChild('st') st: STComponent;
  columns: STColumn[] = [
    { title: '运动项目', index: 'no' },
    { title: '运动强度', index: 'no' },


    {
      title: '操作',
      buttons: [
        {
          text: '编辑',
          click: (item: any) => {
             
          },
        },
        {
          text: '删除',
          click: (item: any) => {
             
          },
        },
      ]
    }
  ];
   
  constructor(private http: _HttpClient, private modal: ModalHelper,private activatedRoute: ActivatedRoute) { 
    //路由传参接受方法
    activatedRoute.queryParams.subscribe(queryParams => {
      //接收日期时间
      this.dateTime = queryParams.date;
  });
  }

  ngOnInit() { 
         console.log(this.dateTime) 
  }

  addSports() {
    this.isVisibleSports = true;
  }

  handleCancel(){
    this.isVisibleSports = false;
  }

}
