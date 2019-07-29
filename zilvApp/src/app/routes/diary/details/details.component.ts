import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicesService } from '../../../httpService/service.service';

@Component({
  selector: 'app-guanli-details',
  templateUrl: './details.component.html',
})
export class GuanliDetailsComponent implements OnInit {
  constructor(
    private http: _HttpClient,
    private modal: ModalHelper,
    private activatedRoute: ActivatedRoute,
    private config: ServicesService,
  ) {}
  data = [];

  dataSet = [
    {
      content: '学习',
      time: '60分钟',
    },
    {
      content: '健身',
      time: '60分钟',
    },
    {
      content: '娱乐',
      time: '180分钟',
    },
    {
      content: '养生',
      time: '0分钟',
    },
    {
      content: '剩余(洗漱,吃饭等)',
      time: '40分钟',
    },
  ];
  // 雷达图
  option = {
    title: {
      text: '今日业余时间分配',
      show: false,
      textStyle: {
        color: '#0099CC',
      },
    },
    tooltip: {
      trigger: 'axis',
    },
    legend: {
      x: 'center',
      show: false,
    },
    toolbox: {
      show: true,
    },
    calculable: true,
    polar: [
      {
        indicator: [
          { text: '学习', max: 200 },
          { text: '健身', max: 200 },
          { text: '娱乐', max: 200 },
          { text: '养生', max: 200 },
          { text: '剩余(洗漱,吃饭等)', max: 200 },
        ],
        // 设置偏移位置
        center: ['45%', 210],
        // 设置半径，雷达图大小
        radius: 80,
      },
    ],
    series: [
      {
        type: 'radar',
        tooltip: {
          trigger: 'item',
        },
        itemStyle: { normal: { areaStyle: { type: 'default' } } },
        color: '#0099CC',
        data: [
          {
            value: [60, 60, 180, 0, 20],
            name: '今日业余时间分配',
          },
        ],
      },
    ],
  };

  ngOnInit(): void {
    console.log(this.data);
  }

  add() {
    // this.modal
    //   .createStatic(FormEditComponent, { i: { id: 0 } })
    //   .subscribe(() => this.st.reload());
  }

  downExcel() {
    const d = this.data;
    console.log(JSON.stringify(d));
    this.config.post(this.config.url + 'Diary/downExcel', { diary: JSON.stringify(d) }).subscribe((res: any) => {
      console.log(res);
      this.data = res;
    });
  }
}
