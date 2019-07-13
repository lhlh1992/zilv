import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { Router} from '@angular/router';
import { ServicesService} from '../../../services/services.service';
import { NzMessageService, NzNotificationService } from 'ng-zorro-antd';
import { GuanliDetailsComponent} from '../details/details.component';


@Component({
  selector: 'app-guanli-guanli-page',
  templateUrl: './guanli-page.component.html',
  styleUrls: ['./guanli-page.component.css']
})
export class GuanliGuanliPageComponent implements OnInit {
  data:any[]=[]; //列表数据
  selectedValue = new Date(); //选中的日期
  Today = new Date(); //日历出师日期，默认当天
  lastTd :any;  //点击事件给dom元素加样式，此参数用于判断清除上一个点击dom的样式
   //=========删除确认弹出框
  isVisibledelete = false;
  todayData=[];//当天数据
  id=[]
  constructor(private http: _HttpClient, private modal: ModalHelper,private router: Router,private config:ServicesService,private message: NzMessageService) {   
  }

  ngOnInit() {
         this.query();   
  }

  //路由传参到编辑页
  jumpHandle(ele,str){
    //这是在html中绑定的click跳转事件
    if(str=='add'){
      this.router.navigate(['/guanli/view'], {
        queryParams: {
            date: ele
        }
    }); 
    }else if(str=='edit'){
      this.router.navigate(['/guanli/view'], {
        queryParams: {           
          Id: ele
        }
    }); 
    }
  }
  
 //获取日记表数据
  query(){
       this.config.post(this.config.url+'Diary/selectDiary',
       {'id':''}
       ) .subscribe((res: any) => {
                  console.log(res)
                  this.data=res;      
   });     
  }
    //新增
    add(date) {
      //如果是点击‘当日新增’
      if(date==undefined){     
        this.jumpHandle( this.dateFtt('yyyy-MM-dd',new Date()),'add');
      }else{
        let m = date.getMonth()+1;
        let d = date.getDate();
        let daTime = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
        if(m<10 && d<10){
          daTime = date.getFullYear()+'-0'+(date.getMonth()+1)+'-0'+date.getDate();
        }else if(m<10 && d>=10){
          daTime = date.getFullYear()+'-0'+(date.getMonth()+1)+'-'+date.getDate();
        }else if(d<10 && m>=10){
          daTime = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
        }     
        this.jumpHandle(daTime,'add');
      } 
    }
    //点击修改按钮
    update(date){    
        this.jumpHandle(date.id,'edit');
    }
    //点击查看详情按钮
    Details(ele){
      //这是在html中绑定的click跳转事件
      //   this.router.navigate(['/guanli/details'], {
      //     queryParams: {           
      //       Id: ele
      //     }
      // });  
     
        this.modal
        .create(GuanliDetailsComponent, {data:ele})
        .subscribe(() => {
          //this.msg.info('回调，重新发起列表刷新');
        // this.queryPerson();
        });  
     
    
    }
 

     //点击日历日期变化事件
    selectChange(select): void {
      //获取节点，获取dom的子节点，
        let d=select.target; 
        let dd=d.parentNode;     
        let td = dd.parentNode;
        let tdd = td.parentNode;   //用于判断是不是最外层区域
        let tddd = tdd.parentNode; //用于判断是不是最外层区域 
        // 点击事件判断清除上一个dom元素的样式
        if( this.lastTd!='' && this.lastTd!=null){
        this.lastTd.setAttribute('style', 'background-color: transparent');
        let but = this.lastTd.getElementsByTagName('button');
        for(let i = 0; i<but.length;i++){
          but[i].style.display='none';
        }
        }
       //判断节点加样式，第一种情况，如果点击区域在td里        
        if(td.title!=''){
          dd.setAttribute('style', 'background-color: #FFCC00');
          let but = dd.getElementsByTagName('button');
          for(let i = 0; i<but.length;i++){
            but[i].style.display='inline';
          }
            this.lastTd = dd 
       //判断节点加样式，第二种情况，如果点击到td里的文字或者td以外的区域
        }     
        else if(td.title==''&& tddd.className!='ant-fullcalendar-calendar-body' && tddd.className!='ant-layout'&& tddd.className!='ant-fullcalendar-header'&& tddd.className!='ant-fullcalendar-table ng-star-inserted'&& tddd.className!='ant-layout-content'){
          if(tddd.className=='notes-month ng-star-inserted' ){             
            let but = dd.getElementsByTagName('button');
            for(let i = 0; i<but.length;i++){
              but[i].style.display='inline';
            } 
            let pp =  tddd.parentNode.parentNode;
                pp.setAttribute('style', 'background-color: #FFCC00');   
                this.lastTd = pp    
         }else if(tddd.className=='ant-fullcalendar-content ng-star-inserted'){
                let but = dd.getElementsByTagName('button');
                for(let i = 0; i<but.length;i++){
                  but[i].style.display='inline';
                }
                let pp =  tddd.parentNode;
                pp.setAttribute('style', 'background-color: #FFCC00');   
                this.lastTd = pp   
                
         }
         else{
                let div = td.parentNode;
                let ddd = div.parentNode; 
                ddd.setAttribute('style', 'background-color: #FFCC00');
                let but = ddd.getElementsByTagName('button');
                for(let i = 0; i<but.length;i++){
                  but[i].style.display='inline';
                }
                this.lastTd = ddd 
         }      
        }                
    }
   //填充日历数据
    getData(date: Date){
      //删除日历表格字典的头部数字
      let paras = document.getElementsByClassName('ant-fullcalendar-value ng-star-inserted');
      for(let i=0;i<paras.length;i++){
              if(paras[i]!=null){
                paras[i].parentNode.removeChild( paras[i]); 
              }
      }
      let m = date.getMonth()+1;
      let d = date.getDate();
      let daTime = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
      if(m<10 && d<10){
        daTime = date.getFullYear()+'-0'+(date.getMonth()+1)+'-0'+date.getDate();
      }else if(m<10 && d>=10){
        daTime = date.getFullYear()+'-0'+(date.getMonth()+1)+'-'+date.getDate();
      }else if(d<10 && m>=10){
        daTime = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
      }     
       for(let item of this.data){
             if(daTime == item.create_time){
              let da =  this.getLunarDateString(this.getLunarDate(daTime))
              let chinaDate 
              if(da.day=='一' || da.day=='二' || da.day=='三'|| da.day=='四'|| da.day=='五'|| da.day=='六'|| da.day=='七'|| da.day=='八'|| da.day=='九'|| da.day=='十'){
               chinaDate = da.month+'月 初'+da.day;
              }else{
               chinaDate = da.month+'月'+da.day;
              }
              item.chinaDate=chinaDate
                  return item
             }
       } 
     let da =  this.getLunarDateString(this.getLunarDate(daTime))
     let chinaDate 
     if(da.day=='一' || da.day=='二' || da.day=='三'|| da.day=='四'|| da.day=='五'|| da.day=='六'|| da.day=='七'|| da.day=='八'|| da.day=='九'|| da.day=='十'){
      chinaDate = da.month+'月 初'+da.day;
     }else{
      chinaDate = da.month+'月'+da.day;
     }
     
     let nullStr = {
            'chinaDate':chinaDate,
            'str':'--暂无记录--',
            'date':daTime
      }
      return nullStr;
    }



 //==========删除相关方法========================
 //字典配置删除确认框关闭事件
 handleCanceldelete(){
  this.isVisibledelete = false;
}
//字典类型点击删除
delete(ele){
  this.todayData = ele;
  this.id=ele.id;
  this.isVisibledelete = true;
}
//删除方法
handledelete(){
  this.config.post(this.config.url+'Diary/delDiary',
  {id:this.id}
  ) .subscribe((res: any) => {
              if(res==1){
                this.message.success('删除成功');
                this.isVisibledelete = false;
                //刷新列表
                this.query();     
              }
    });  
}

//=============导出=======================

download(){
  this.config.post(this.config.url+'Diary/downExcel',
  {'id':''}
  ) .subscribe((res: any) => {
             console.log(res)
             this.data=res;      
});     
}
  
//======================================================日期转换农历日期
 lunar = {
    tg: '甲乙丙丁戊己庚辛壬癸',
    dz: '子丑寅卯辰巳午未申酉戌亥',
    number: '一二三四五六七八九十',
    year: '鼠牛虎兔龙蛇马羊猴鸡狗猪',
    month: '正二三四五六七八九十冬腊',
    monthadd: [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334],
    calendar: [0xA4B, 0x5164B, 0x6A5, 0x6D4, 0x415B5, 0x2B6, 0x957, 0x2092F, 0x497, 0x60C96, 0xD4A, 0xEA5, 0x50DA9, 0x5AD, 0x2B6, 0x3126E, 0x92E, 0x7192D, 0xC95, 0xD4A, 0x61B4A, 0xB55, 0x56A, 0x4155B, 0x25D, 0x92D, 0x2192B, 0xA95, 0x71695, 0x6CA, 0xB55, 0x50AB5, 0x4DA, 0xA5B, 0x30A57, 0x52B, 0x8152A, 0xE95, 0x6AA, 0x615AA, 0xAB5, 0x4B6, 0x414AE, 0xA57, 0x526, 0x31D26, 0xD95, 0x70B55, 0x56A, 0x96D, 0x5095D, 0x4AD, 0xA4D, 0x41A4D, 0xD25, 0x81AA5, 0xB54, 0xB6A, 0x612DA, 0x95B, 0x49B, 0x41497, 0xA4B, 0xA164B, 0x6A5, 0x6D4, 0x615B4, 0xAB6, 0x957, 0x5092F, 0x497, 0x64B, 0x30D4A, 0xEA5, 0x80D65, 0x5AC, 0xAB6, 0x5126D, 0x92E, 0xC96, 0x41A95, 0xD4A, 0xDA5, 0x20B55, 0x56A, 0x7155B, 0x25D, 0x92D, 0x5192B, 0xA95, 0xB4A, 0x416AA, 0xAD5, 0x90AB5, 0x4BA, 0xA5B, 0x60A57, 0x52B, 0xA93, 0x40E95]
}
 getLunarDate(date) {
  let year=0 
  let month=0
  let day=0
  if (!date) {
      date = new Date(), year = date.getFullYear(), month = date.getMonth(), day = date.getDate();
  } else {
      date = date.split('-'), year = parseInt(date[0]), month = date[1] - 1, day = parseInt(date[2]);
  }

  if (year < 1921 || year > 2020) {
      return {}
  }

  var total, 
  m, n, k, bit, lunarYear, lunarMonth, lunarDay;
  var isEnd = false;
  var tmp = year;
  if (tmp < 1900) {
      tmp += 1900;
  }
  total = (tmp - 1921) * 365 + Math.floor((tmp - 1921) / 4) + this.lunar.monthadd[month] + day - 38;
  if (year % 4 == 0 && month > 1) {
      total++;
  }
  for (m = 0;; m++) {
      k = (this.lunar.calendar[m] < 0xfff) ? 11 : 12;
      for (n = k; n >= 0; n--) {
          bit = (this.lunar.calendar[m] >> n) & 1;
          if (total <= 29 + bit) {
              isEnd = true;
              break;
          }
          total = total - 29 - bit;
      }
      if (isEnd) break;
  }
  lunarYear = 1921 + m;
  lunarMonth = k - n + 1;
  lunarDay = total;
  if (k == 12) {
      if (lunarMonth == Math.floor(this.lunar.calendar[m] / 0x10000) + 1) {
          lunarMonth = 1 - lunarMonth;
      }
      if (lunarMonth > Math.floor(this.lunar.calendar[m] / 0x10000) + 1) {
          lunarMonth--;
      }
  }

  return {
      lunarYear: lunarYear,
      lunarMonth: lunarMonth,
      lunarDay: lunarDay,
  };
}

 getLunarDateString(lunarDate) {
  if (!lunarDate.lunarDay) return;
  
    let  lunarYear = lunarDate.lunarYear
    let  lunarMonth = lunarDate.lunarMonth
    let  lunarDay = lunarDate.lunarDay;

  let tg = this.lunar.tg.charAt((lunarYear - 4) % 10);
  let dz = this.lunar.dz.charAt((lunarYear - 4) % 12);
  let year = this.lunar.year.charAt((lunarYear - 4) % 12);
  let month = lunarMonth < 1 ? '(闰)' + this.lunar.month.charAt(-lunarMonth - 1) : this.lunar.month.charAt(lunarMonth - 1);

  let day = (lunarDay < 11) ? "初" : ((lunarDay < 20) ? "十" : ((lunarDay < 30) ? "廿" : "三十"));
  if (lunarDay % 10 != 0 || lunarDay == 10) {
     day = this.lunar.number.charAt((lunarDay - 1) % 10);
  }
  var data = {
    tg,
    dz,
    year,
    month,
    day
  }
  return data;
}
//========================================================================================


//日期格式化
dateFtt(fmt,date)   
{ //author: meizz   
  var o = {   
    "M+" : date.getMonth()+1,                 //月份   
    "d+" : date.getDate(),                    //日   
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

}
