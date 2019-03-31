import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ActivatedRoute} from '@angular/router';
import { ServicesService} from '../../../services/services.service';
@Component({
  selector: 'app-guanli-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class GuanliViewComponent implements OnInit {
  dateTime=''
  sportsData:any[]=[];//运动项目表数据

  isVisibleSports = false;
  checked = false;
  //数字输入框==============
  demoValue = 0;
  formatterDollar = (value: number) => `${value}分钟`;
  parserDollar = (value: string) => value.replace('$ ', '');
  //===============================================

  url = `/user`;
  searchSchema: SFSchema = {
    properties: {
      no: {
        type: 'string',
        title: '编号'
      }
    }
  };
  //运动项目表数据
  listOfData = [    
   
  ]; 

  @ViewChild('st') st: STComponent;
  columns: STColumn[] = [
    { title: '运动项目', index: 'no' },
    { title: '是否完成', index: 'no' },
    { title: '运行时常', index: 'no' },

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
   
  constructor(private http: _HttpClient, private modal: ModalHelper,private activatedRoute: ActivatedRoute,private config:ServicesService) { 
    //路由传参接受方法
    activatedRoute.queryParams.subscribe(queryParams => {
      //接收日期时间
      this.dateTime= queryParams.date;
  });
  }

  ngOnInit() { 
         this.queryItem();
  }
   //获取字典配置列表
   queryItem(){
    this.http.post(this.config.url+'dic/dicitemList',
    {name:'sports_type'}
    ) .subscribe((res: any) => {
             console.log(res)
             
             this.listOfData = res
             let l = res.length;


             
      });
  }

  //数字时间框改变事件
  ChangeNum(value: number){
      for(let item of this.listOfData){
        item.sportsTime = value
      }
  }
  add(){
          let tr = document.getElementsByTagName('tr');
          let listmap=[]
          for(let i=0;i<tr.length;i++){
               let tdList =  tr[i].getElementsByTagName('td')
               let map=new Map();
                  for(let j = 0;j<tdList.length;j++){
                      let num = '';                 
                      let typeName = tdList[j].innerText                     
                      let input =  tdList[j].getElementsByTagName('input')  
                      for(let n = 0;n<input.length;n++){
                              let nn = input[n];
                              num = nn.getAttribute('ng-reflect-model')
                      }                               
                     map.set(typeName,num);
                  }
                  listmap.push(map)
          }
          console.log(listmap)
  }





















  
}
