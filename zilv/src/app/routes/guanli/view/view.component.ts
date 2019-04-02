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

  //==========================双向绑定数据库对应字段
  studyTimeStart: Date | null = null; //学习开始时间
  studyTimeEnd: Date | null = null;   //学习结束时间
  studyContent = ''  //学习内容
  jsTimeStart: Date | null = null; //健身开始时间
  jsTimeEnd: Date | null = null; //健身结束时间
  listmap=[]  //健身内容
  sleepTime:Date | null = null; //晚上睡觉时间
  ajTimeStart:Date | null = null;//艾灸开始时间
  ajTimeEnd:Date | null = null;//艾灸结束时间
  dinner=[]; //今日饮食数组
  BadHabits='' //是否戒撸
  healthStatus = '' //是否尿床
  appetite = '' //有无宵夜
  faceWash = '' //是否洗脸
  brushTooth = '' //是否刷牙
  sentiment= ''  //心情日记
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
  dietData = [];//饮食字典列表

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
         this.queryDiet();
  }
   //获取运动字典配置列表
   queryItem(){
    this.http.post(this.config.url+'dic/dicitemList',
    {code:'sports_type'}
    ) .subscribe((res: any) => {       
             this.listOfData = res           
      });
  }
    //获取饮食字典配置列表
    queryDiet(){
      this.http.post(this.config.url+'dic/dicitemList',
      {code:'diet_type'}
      ) .subscribe((res: any) => {     
               this.dietData = res          
        });
    }

  //数字时间框改变事件
  ChangeNum(value: number){
      for(let item of this.listOfData){
        item.sportsTime = value
      }
  }
  //最终添加事件
  add(){
          let tr = document.getElementsByTagName('tr');  

          let map=new Map();
          let nameList = []
          let numList  = []
          for(let i=0;i<tr.length;i++){
               let tdList =  tr[i].getElementsByTagName('td')
             
              
              
                  for(let j = 0;j<tdList.length;j++){
                      let num = '';                 
                      let typeName = tdList[j].innerText                     
                      let input =  tdList[j].getElementsByTagName('input')  
                      for(let n = 0;n<input.length;n++){
                              let nn = input[n];
                              num = nn.getAttribute('ng-reflect-model')
                      }                               
                    // map.set(typeName,num);

                      if(typeName!=''){
                        nameList.push(typeName)
                      }
                      if(num!=''){
                        numList.push(num)
                      }

                  }
                for(let name of nameList){
                
                     for(let num of numList){
                           map.set(name,num);
                           
                     }
                    //  console.log(map)
                    // let m= JSON.stringify(this.strMapToObj(map));
                    //     console.log(m)
                }
                            
          }
     
          this.listmap.push(map)
          // console.log(this.listmap)
           console.log(nameList)
           console.log(numList)
          let myMap = new Map().set('yes', true).set('no', false);
       


       
       this.http.post(this.config.url+'Diary/addDiary',
          {studyTimeStart:this.dateFtt('hh:mm',this.studyTimeStart)==null?'':this.dateFtt('hh:mm',this.studyTimeStart),
           studyTimeEnd:this.dateFtt('hh:mm',this.studyTimeEnd)==null?'':this.dateFtt('hh:mm',this.studyTimeEnd),
           studyContent:this.studyContent,
           jsTimeStart:this.dateFtt('hh:mm',this.jsTimeStart)==null?'':this.dateFtt('hh:mm',this.jsTimeStart),
           jsTimeEnd:this.dateFtt('hh:mm',this.jsTimeEnd)==null?'':this.dateFtt('hh:mm',this.jsTimeEnd),
           nameList:nameList,
           numList:numList,
           sleepTime:this.dateFtt('hh:mm',this.sleepTime)==null?'':this.dateFtt('hh:mm',this.sleepTime),
           ajTimeStart:this.dateFtt('hh:mm',this.ajTimeStart)==null?'':this.dateFtt('hh:mm',this.ajTimeStart),
           ajTimeEnd:this.dateFtt('hh:mm',this.ajTimeEnd)==null?'':this.dateFtt('hh:mm',this.ajTimeEnd),
           dinner:this.dinner,
           BadHabits:this.BadHabits,
           healthStatus:this.healthStatus,
           appetite:this.appetite,
           faceWash:this.faceWash,
           brushTooth:this.brushTooth,
           sentiment:this.sentiment,
           create_time:this.dateTime
          }
          ) .subscribe((res: any) => {       
                  console.log(res);          
            });
          
        

  }
  //今日饮食多选事件 
  checkbox(ele){
    this.dinner = ele
  }
  //=========时间控件数据提取
  studyTime1(time: Date): void {

    if(time!=null){
      this.studyTimeStart = time
    }
   
  }
  studyTime2(time: Date): void {
    if(time!=null){
    this.studyTimeEnd = time
    }
  }
  jsTime1(time: Date): void {
    if(time!=null){
    this.jsTimeStart = time
    }
  }
  jsTime2(time: Date): void {
    if(time!=null){
    this.jsTimeEnd = time
    }
  }
  sleepTimefon(time: Date): void {
    if(time!=null){
    this.sleepTime = time
    }
  }
  ajTime1(time: Date): void {
    if(time!=null){
    this.ajTimeStart = time
    }
  }
  ajTime2(time: Date): void {
    if(time!=null){
    this.ajTimeEnd = time
    }  }
 //==================================




//============================================日期格式化
dateFtt(fmt,date)   

{ //author: meizz   
  if(date==''||date==null){
      return;
  }
  var o = {   
    // "M+" : date.getMonth()+1,                 //月份   
    // "d+" : date.getDate(),                    //日   
    "h+" : date.getHours(),                   //小时   
    "m+" : date.getMinutes(),                 //分   
    "s+" : date.getSeconds(),                 //秒   
    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
    "S"  : date.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
} 
//==================================================================



strMapToObj(strMap){

  let obj= Object.create(null);
  for (let[k,v] of strMap) {
    obj[k] = v;
  }
  return obj;
}








  
}
