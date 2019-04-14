import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ActivatedRoute,Router} from '@angular/router';
import { ServicesService} from '../../../services/services.service';
import { NzMessageService, NzNotificationService } from 'ng-zorro-antd';
@Component({
  selector: 'app-guanli-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class GuanliViewComponent implements OnInit {
  dateTime=''
  sportsData:any[]=[];//运动项目表数据
  rijiId = '';//回填数据ID
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
  dietData = [];//饮食字典列表
 //==============================================
  //运动项目表数据
  listOfData = []; 


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
   
  constructor(private http: _HttpClient, private modal: ModalHelper,private activatedRoute: ActivatedRoute,private config:ServicesService, private router: Router,private message: NzMessageService) { 
    //路由传参接受方法
    activatedRoute.queryParams.subscribe(queryParams => {
      //接收日期时间
      
      if(queryParams.date!=null&&queryParams.date!=''&&queryParams.date!=undefined){
        this.dateTime = queryParams.date
      
      }
      if(queryParams.Id!=null&&queryParams.Id!=''&&queryParams.Id!=undefined){
        this.rijiId = queryParams.Id
      }
      
  });
  }

  ngOnInit() { 
         this.queryItem();
         this.queryDiet();
         if(this.rijiId!=''){
          this.queryRiji();
         }
         
  }
  //获取回填
  queryRiji(){
    console.log('获取回填。。。。。。')
      this.http.post(this.config.url+'Diary/selectDiary',
      {'id':this.rijiId}
      ) .subscribe((res: any) => {
             this.dateTime = res[0].create_time!=''?res[0].create_time:'';//获取添加时间，当做页面回填展示
             this.studyContent = res[0].studyContent!=''?res[0].studyContent:'';
             if(res[0].studyTimeStart!=''&&res[0].studyTimeStart!=null){
              this.studyTimeStart = new Date('2018/01/01  '+res[0].studyTimeStart)
             }
             if(res[0].studyTimeEnd!=''&&res[0].studyTimeEnd!=null){
              this.studyTimeEnd   = new Date('2018/01/01  '+res[0].studyTimeEnd)
             }
             if(res[0].sportsTimeStart!=''&&res[0].sportsTimeStart!=null){
              this.jsTimeStart = new Date('2018/01/01  '+res[0].sportsTimeStart)
             }
             if(res[0].sportsTimeEnd!=''&&res[0].sportsTimeEnd!=null){
              this.jsTimeEnd   = new Date('2018/01/01  '+res[0].sportsTimeEnd)
             }
             if(res[0].aijiuTimeStart!=''&&res[0].aijiuTimeStart!=null){
              this.ajTimeStart = new Date('2018/01/01  '+res[0].aijiuTimeStart)
             }
             if(res[0].aijiuTimeEnd!=''&&res[0].aijiuTimeEnd!=null){
              this.ajTimeEnd   = new Date('2018/01/01  '+res[0].aijiuTimeEnd)
             }
             if(res[0].sleepTime!=''&&res[0].sleepTime!=null){
              this.sleepTime   = new Date('2018/01/01  '+res[0].sleepTime)
             }    
             this.BadHabits = res[0].badHabits;
             this.healthStatus = res[0].healthStatus;
             this.appetite  =  res[0].appetite;
             this.faceWash  =  res[0].faceWash;
             this.brushTooth  =  res[0].brushTooth;
             this.sentiment  =  res[0].sentiment;
             let str = res[0].dinner;
             console.log(str)
             //回填饮食多选框
             this.dinner =  str.replace('[','').replace(']','').split(',');
              for(let d of this.dietData){
                for(let item of this.dinner){
                        if(item.replace(/\s+/g,"")==d.value){
                              d.checked=true
                        }
                }  
              }
              console.log(this.dietData)
              //===============回填运动项目=====================  
              let sportsContent=res[0].sportsContent
              sportsContent= sportsContent.replace('[','').replace(']','').split(',');
              for(let map of sportsContent){
                    let strList=map.replace('{','').replace('}','').split('=')            
                    for(let item of this.listOfData){
                          let type=strList[0]
                          if(item.dicItemName==type.replace(/\s*/g,"")){                        
                            item.sportsTime=strList[1].trim()
                            break;
                          }
                    }
              }
      }); 
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
      console.log('获取饮食字典。。。。。。')
      this.http.post(this.config.url+'dic/dicitemList',
      {code:'diet_type'}
      ) .subscribe((res: any) => {  
               let map={} 
               for(let item of res){
                map={
                  label:item.dicItemName,
                  value:item.dicItemCode,
                  checked:false
                } 
                this.dietData.push(map) 
               }              
        });
        console.log(this.dietData)
    }

  //数字时间框改变事件
  ChangeNum(value){
      for(let item of this.listOfData){
         for(let v of value){
              if(item.dicItemCode==v.dicItemCode){
                item.sportsTime = v.sportsTime
              }
         }    
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
                }                            
          }    
          let dinnerList = [];
        this.listmap.push(map)  
        for(let item of this.dietData){
              if(item.checked==true){
                dinnerList.push(item.value)
              }
        }
        let addORedit=''
        let message = ''
        if(this.rijiId==''){
          addORedit='Diary/addDiary'
          message='添加'
        }else{
          addORedit='Diary/editDiary' 
          message='修改'
        }      
        this.http.post(this.config.url+addORedit,
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
         dinner:dinnerList,
         BadHabits:this.BadHabits,
         healthStatus:this.healthStatus,
         appetite:this.appetite,
         faceWash:this.faceWash,
         brushTooth:this.brushTooth,
         sentiment:this.sentiment,
         create_time:this.dateTime,
         id:this.rijiId
        }
        ) .subscribe((res: any) => {       
                if(res>0){
                  this.message.create('Success', message+'日记成功ヾ(◍°∇°◍)ﾉﾞ!记得每天写日记噢~');
                  this.router.navigate(['/guanli/guanliPage']);
                }          
          });
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
