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

  // =========================

  nodes = [
    {
      value: '66666666',
      type: 'home',
      index: '0',
    },
    {
      value: '11111111111',
      type: 'phone',
      index: '1',
    },
    {
      value: '22222222222',
      type: 'phone',
      index: '2',
    },
    {
      value: '33333333333',
      type: 'phone',
      index: '3',
    },
    {
      value: '44444444444',
      type: 'phone',
      index: '4',
    },
    {
      value: '55555555555',
      type: 'phone',
      index: '5',
    },
    {
      value: 'aaa',
      type: 'weixin',
      index: '6',
    },
    {
      value: 'bbb',
      type: 'weixin',
      index: '7',
    },
    {
      value: 'ccc',
      type: 'weixin',
      index: '8',
    },
    {
      value: 'ddd',
      type: 'weixin',
      index: '9',
    },
    {
      value: 'eee',
      type: 'weixin',
      index: '10',
    },
    {
      value: 'fff',
      type: 'weixin',
      index: '11',
    },
  ];
  links = [
    {
      source: 0,
      target: 1,
    },
    {
      source: 0,
      target: 2,
    },
    {
      source: 0,
      target: 3,
    },
    {
      source: 0,
      target: 4,
    },
    {
      source: 0,
      target: 5,
    },
    {
      source: 2,
      target: 6,
    },
    {
      source: 2,
      target: 7,
    },
    {
      source: 2,
      target: 8,
    },
    {
      source: 3,
      target: 9,
    },
    {
      source: 3,
      target: 10,
    },
    {
      source: 3,
      target: 11,
    },
  ];
  // ================================

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
