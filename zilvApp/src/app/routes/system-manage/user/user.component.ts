import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ServicesService } from '../../../httpService/service.service';
import { UserBean } from './user';

@Component({
  selector: 'app-system-manage-user',
  templateUrl: './user.component.html',
})
export class SystemManageUserComponent implements OnInit {
  constructor(private http: _HttpClient, private modal: ModalHelper, private config: ServicesService) {}
  data: '';

  @ViewChild('st', { static: false }) st: STComponent;
  columns: STColumn[] = [
    { title: '用户名', index: 'username' },
    { title: '所属角色', index: 'roleStr' },
    { title: '是否启用', index: 'is_Banning', renderTitle: 'customTitle', render: 'custom' },
    {
      title: '操作',
      buttons: [{ text: '查看' }, { text: '编辑' }],
    },
  ];

  ngOnInit() {
    this.query();
  }

  add() {}

  query() {
    this.config.post(this.config.url + 'user/getUserList', { username: '' }).subscribe((res: any) => {
      this.data = res;
    });
  }
}
