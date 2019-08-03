import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { Router } from '@angular/router';
import { ServicesService } from '../../../httpService/service.service';
import { NzMessageService, NzNotificationService } from 'ng-zorro-antd';
import { GuanliDetailsComponent } from '../details/details.component';

@Component({
  selector: 'app-guanli-guanli-page',
  templateUrl: './guanli-page.component.html',
  styleUrls: ['./guanli-page.component.css'],
})
export class GuanliGuanliPageComponent implements OnInit {
  constructor(
    private http: _HttpClient,
    private modal: ModalHelper,
    private router: Router,
    private config: ServicesService,
    private message: NzMessageService,
  ) {}
  data: any[] = []; // 列表数据
  selectedValue = new Date(); // 选中的日期
  Today = new Date(); // 日历出师日期，默认当天
  lastTd: any; // 点击事件给dom元素加样式，此参数用于判断清除上一个点击dom的样式
  // =========删除确认弹出框
  isVisibledelete = false;
  todayData = []; // 当天数据
  id = [];

  // ======================================================日期转换农历日期
  lunar = {
    tg: '甲乙丙丁戊己庚辛壬癸',
    dz: '子丑寅卯辰巳午未申酉戌亥',
    number: '一二三四五六七八九十',
    year: '鼠牛虎兔龙蛇马羊猴鸡狗猪',
    month: '正二三四五六七八九十冬腊',
    monthadd: [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334],
    calendar: [
      0xa4b,
      0x5164b,
      0x6a5,
      0x6d4,
      0x415b5,
      0x2b6,
      0x957,
      0x2092f,
      0x497,
      0x60c96,
      0xd4a,
      0xea5,
      0x50da9,
      0x5ad,
      0x2b6,
      0x3126e,
      0x92e,
      0x7192d,
      0xc95,
      0xd4a,
      0x61b4a,
      0xb55,
      0x56a,
      0x4155b,
      0x25d,
      0x92d,
      0x2192b,
      0xa95,
      0x71695,
      0x6ca,
      0xb55,
      0x50ab5,
      0x4da,
      0xa5b,
      0x30a57,
      0x52b,
      0x8152a,
      0xe95,
      0x6aa,
      0x615aa,
      0xab5,
      0x4b6,
      0x414ae,
      0xa57,
      0x526,
      0x31d26,
      0xd95,
      0x70b55,
      0x56a,
      0x96d,
      0x5095d,
      0x4ad,
      0xa4d,
      0x41a4d,
      0xd25,
      0x81aa5,
      0xb54,
      0xb6a,
      0x612da,
      0x95b,
      0x49b,
      0x41497,
      0xa4b,
      0xa164b,
      0x6a5,
      0x6d4,
      0x615b4,
      0xab6,
      0x957,
      0x5092f,
      0x497,
      0x64b,
      0x30d4a,
      0xea5,
      0x80d65,
      0x5ac,
      0xab6,
      0x5126d,
      0x92e,
      0xc96,
      0x41a95,
      0xd4a,
      0xda5,
      0x20b55,
      0x56a,
      0x7155b,
      0x25d,
      0x92d,
      0x5192b,
      0xa95,
      0xb4a,
      0x416aa,
      0xad5,
      0x90ab5,
      0x4ba,
      0xa5b,
      0x60a57,
      0x52b,
      0xa93,
      0x40e95,
    ],
  };

  ngOnInit() {
    this.query();
  }

  // 路由传参到编辑页
  jumpHandle(ele, str) {
    // 这是在html中绑定的click跳转事件
    if (str == 'add') {
      this.router.navigate(['/diary/view'], {
        queryParams: {
          date: ele,
        },
      });
    } else if (str == 'edit') {
      this.router.navigate(['/diary/view'], {
        queryParams: {
          Id: ele,
        },
      });
    }
  }

  // 获取日记表数据
  query() {
    this.config.post(this.config.url + 'Diary/selectDiary', { id: '' }).subscribe((res: any) => {
      this.data = res;
    });
  }
  // 新增
  add(date) {
    // 如果是点击‘当日新增’
    if (date == undefined) {
      this.jumpHandle(this.dateFtt('yyyy-MM-dd', new Date()), 'add');
    } else {
      const m = date.getMonth() + 1;
      const d = date.getDate();
      let daTime = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
      if (m < 10 && d < 10) {
        daTime = date.getFullYear() + '-0' + (date.getMonth() + 1) + '-0' + date.getDate();
      } else if (m < 10 && d >= 10) {
        daTime = date.getFullYear() + '-0' + (date.getMonth() + 1) + '-' + date.getDate();
      } else if (d < 10 && m >= 10) {
        daTime = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
      }
      this.jumpHandle(daTime, 'add');
    }
  }
  // 点击修改按钮
  update(date) {
    this.jumpHandle(date.id, 'edit');
  }
  // 点击查看详情按钮
  Details(ele) {
    // 这是在html中绑定的click跳转事件
    //   this.router.navigate(['/guanli/details'], {
    //     queryParams: {
    //       Id: ele
    //     }
    // });

    this.modal.create(GuanliDetailsComponent, { data: ele }).subscribe(() => {
      // this.msg.info('回调，重新发起列表刷新');
      // this.queryPerson();
    });
  }

  // 点击日历日期变化事件
  selectChange(select): void {
    // 获取节点，获取dom的子节点，
    const d = select.target;
    const dd = d.parentNode;
    const td = dd.parentNode;
    const tdd = td.parentNode; // 用于判断是不是最外层区域
    const tddd = tdd.parentNode; // 用于判断是不是最外层区域
    // 点击事件判断清除上一个dom元素的样式
    if (this.lastTd != '' && this.lastTd != null) {
      this.lastTd.setAttribute('style', 'background-color: transparent');
      const but = this.lastTd.getElementsByTagName('button');
      for (let i = 0; i < but.length; i++) {
        but[i].style.display = 'none';
      }
    }
    // 判断节点加样式，第一种情况，如果点击区域在td里
    if (td.title != '') {
      dd.setAttribute('style', 'background-color: #FFCC00');
      const but = dd.getElementsByTagName('button');
      for (let i = 0; i < but.length; i++) {
        but[i].style.display = 'inline';
      }
      this.lastTd = dd;
      // 判断节点加样式，第二种情况，如果点击到td里的文字或者td以外的区域
    } else if (
      td.title == '' &&
      tddd.className != 'ant-fullcalendar-calendar-body' &&
      tddd.className != 'ant-layout' &&
      tddd.className != 'ant-fullcalendar-header' &&
      tddd.className != 'ant-fullcalendar-table ng-star-inserted' &&
      tddd.className != 'ant-layout-content'
    ) {
      if (tddd.className == 'notes-month ng-star-inserted') {
        const but = dd.getElementsByTagName('button');
        for (let i = 0; i < but.length; i++) {
          but[i].style.display = 'inline';
        }
        const pp = tddd.parentNode.parentNode;
        pp.setAttribute('style', 'background-color: #FFCC00');
        this.lastTd = pp;
      } else if (tddd.className == 'ant-fullcalendar-content ng-star-inserted') {
        const but = dd.getElementsByTagName('button');
        for (let i = 0; i < but.length; i++) {
          but[i].style.display = 'inline';
        }
        const pp = tddd.parentNode;
        pp.setAttribute('style', 'background-color: #FFCC00');
        this.lastTd = pp;
      } else {
        const div = td.parentNode;
        const ddd = div.parentNode;
        ddd.setAttribute('style', 'background-color: #FFCC00');
        const but = ddd.getElementsByTagName('button');
        for (let i = 0; i < but.length; i++) {
          but[i].style.display = 'inline';
        }
        this.lastTd = ddd;
      }
    }
  }
  // 填充日历数据
  getData(date: Date) {
    // 删除日历表格字典的头部数字
    const paras = document.getElementsByClassName('ant-fullcalendar-value ng-star-inserted');
    for (let i = 0; i < paras.length; i++) {
      if (paras[i] != null) {
        paras[i].parentNode.removeChild(paras[i]);
      }
    }
    const m = date.getMonth() + 1;
    const d = date.getDate();
    let daTime = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
    if (m < 10 && d < 10) {
      daTime = date.getFullYear() + '-0' + (date.getMonth() + 1) + '-0' + date.getDate();
    } else if (m < 10 && d >= 10) {
      daTime = date.getFullYear() + '-0' + (date.getMonth() + 1) + '-' + date.getDate();
    } else if (d < 10 && m >= 10) {
      daTime = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
    }
    for (const item of this.data) {
      if (daTime == item.create_time) {
        const da = this.getLunarDateString(this.getLunarDate(daTime));
        let chinaDate;
        if (
          da.day == '一' ||
          da.day == '二' ||
          da.day == '三' ||
          da.day == '四' ||
          da.day == '五' ||
          da.day == '六' ||
          da.day == '七' ||
          da.day == '八' ||
          da.day == '九' ||
          da.day == '十'
        ) {
          chinaDate = da.month + '月 初' + da.day;
        } else {
          chinaDate = da.month + '月' + da.day;
        }
        item.chinaDate = chinaDate;
        return item;
      }
    }
    const da = this.getLunarDateString(this.getLunarDate(daTime));
    let chinaDate;
    if (
      da.day == '一' ||
      da.day == '二' ||
      da.day == '三' ||
      da.day == '四' ||
      da.day == '五' ||
      da.day == '六' ||
      da.day == '七' ||
      da.day == '八' ||
      da.day == '九' ||
      da.day == '十'
    ) {
      chinaDate = da.month + '月 初' + da.day;
    } else {
      chinaDate = da.month + '月' + da.day;
    }

    const nullStr = {
      chinaDate,
      str: '--暂无记录--',
      date: daTime,
    };
    return nullStr;
  }

  // ==========删除相关方法========================
  // 字典配置删除确认框关闭事件
  handleCanceldelete() {
    this.isVisibledelete = false;
  }
  // 字典类型点击删除
  delete(ele) {
    this.todayData = ele;
    this.id = ele.id;
    this.isVisibledelete = true;
  }
  // 删除方法
  handledelete() {
    this.config.post(this.config.url + 'Diary/delDiary', { id: this.id }).subscribe((res: any) => {
      if (res == 1) {
        this.message.success('删除成功');
        this.isVisibledelete = false;
        // 刷新列表
        this.query();
      }
    });
  }

  // =============导出=======================

  download() {
    this.config.post(this.config.url + 'Diary/downExcel', { id: '' }).subscribe((res: any) => {
      console.log(res);
      this.data = res;
    });
  }
  getLunarDate(date) {
    let year = 0;
    let month = 0;
    let day = 0;
    if (!date) {
      (date = new Date()), (year = date.getFullYear()), (month = date.getMonth()), (day = date.getDate());
    } else {
      (date = date.split('-')), (year = parseInt(date[0])), (month = date[1] - 1), (day = parseInt(date[2]));
    }

    if (year < 1921 || year > 2020) {
      return {};
    }

    let total, m, n, k, bit, lunarYear, lunarMonth, lunarDay;
    let isEnd = false;
    let tmp = year;
    if (tmp < 1900) {
      tmp += 1900;
    }
    total = (tmp - 1921) * 365 + Math.floor((tmp - 1921) / 4) + this.lunar.monthadd[month] + day - 38;
    if (year % 4 == 0 && month > 1) {
      total++;
    }
    for (m = 0; ; m++) {
      k = this.lunar.calendar[m] < 0xfff ? 11 : 12;
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
      lunarYear,
      lunarMonth,
      lunarDay,
    };
  }

  getLunarDateString(lunarDate) {
    if (!lunarDate.lunarDay) return;

    const lunarYear = lunarDate.lunarYear;
    const lunarMonth = lunarDate.lunarMonth;
    const lunarDay = lunarDate.lunarDay;

    const tg = this.lunar.tg.charAt((lunarYear - 4) % 10);
    const dz = this.lunar.dz.charAt((lunarYear - 4) % 12);
    const year = this.lunar.year.charAt((lunarYear - 4) % 12);
    const month =
      lunarMonth < 1 ? '(闰)' + this.lunar.month.charAt(-lunarMonth - 1) : this.lunar.month.charAt(lunarMonth - 1);

    let day = lunarDay < 11 ? '初' : lunarDay < 20 ? '十' : lunarDay < 30 ? '廿' : '三十';
    if (lunarDay % 10 != 0 || lunarDay == 10) {
      day = this.lunar.number.charAt((lunarDay - 1) % 10);
    }
    const data = {
      tg,
      dz,
      year,
      month,
      day,
    };
    return data;
  }
  // ========================================================================================

  // 日期格式化
  dateFtt(fmt, date) {
    // author: meizz
    const o = {
      'M+': date.getMonth() + 1, // 月份
      'd+': date.getDate(), // 日
      'h+': date.getHours(), // 小时
      'm+': date.getMinutes(), // 分
      's+': date.getSeconds(), // 秒
      'q+': Math.floor((date.getMonth() + 3) / 3), // 季度
      S: date.getMilliseconds(), // 毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
    for (const k in o)
      if (new RegExp('(' + k + ')').test(fmt))
        fmt = fmt.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ('00' + o[k]).substr(('' + o[k]).length));
    return fmt;
  }
}
