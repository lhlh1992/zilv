import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ServicesService } from '../../../httpService/service.service';
import { UserBean } from './user';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NzMessageService, NzModalService } from 'ng-zorro-antd';
import { NzFormatEmitEvent } from 'ng-zorro-antd';
@Component({
  selector: 'app-system-manage-user',
  templateUrl: './user.component.html',
})
export class SystemManageUserComponent implements OnInit {
  constructor(
    private http: _HttpClient,
    private modal: ModalHelper,
    private config: ServicesService,
    private fb: FormBuilder,
    private msg: NzMessageService,
  ) {}
  validateForm: FormGroup; // 表单的验证
  data: '';
  user: UserBean;
  // 用户编辑模态框
  isVisible = false;
  isVisiblePassword = false;

  // ==字段双向绑定====
  username = '';
  password = '';
  checkPassword = '';
  uid = '';
  // ================

  // ====删除模态框
  isVisibledelete = false;

  // =====分类角色模态框
  isVisibleRole = false;

  defaultCheckedKeys = ['0-0-0'];
  defaultSelectedKeys = ['0-0-0'];
  defaultExpandedKeys = ['0-0', '0-0-0', '0-0-1'];

  nodes = [
    {
      title: '0-0',
      key: '0-0',
      expanded: true,
      children: [
        {
          title: '0-0-0',
          key: '0-0-0',
          children: [
            { title: '0-0-0-0', key: '0-0-0-0', isLeaf: true },
            { title: '0-0-0-1', key: '0-0-0-1', isLeaf: true },
            { title: '0-0-0-2', key: '0-0-0-2', isLeaf: true },
          ],
        },
        {
          title: '0-0-1',
          key: '0-0-1',
          children: [
            { title: '0-0-1-0', key: '0-0-1-0', isLeaf: true },
            { title: '0-0-1-1', key: '0-0-1-1', isLeaf: true },
            { title: '0-0-1-2', key: '0-0-1-2', isLeaf: true },
          ],
        },
        {
          title: '0-0-2',
          key: '0-0-2',
          isLeaf: true,
        },
      ],
    },
    {
      title: '0-1',
      key: '0-1',
      children: [
        { title: '0-1-0-0', key: '0-1-0-0', isLeaf: true },
        { title: '0-1-0-1', key: '0-1-0-1', isLeaf: true },
        { title: '0-1-0-2', key: '0-1-0-2', isLeaf: true },
      ],
    },
    {
      title: '0-2',
      key: '0-2',
      isLeaf: true,
    },
  ];

  // ===================================================================

  @ViewChild('st', { static: false }) st: STComponent;
  columns: STColumn[] = [
    { title: '用户名', index: 'username' },
    { title: '所属角色', index: 'roleStr' },
    { title: '是否启用', index: 'banning', renderTitle: 'customTitle', render: 'custom' },
    {
      title: '操作',
      buttons: [
        {
          text: '修改密码',
          click: (item: any) => {
            this.edit(item);
          },
        },
        {
          text: '删除',
          click: (item: any) => {
            this.delete(item);
          },
        },
        {
          text: '分配角色',
          click: (item: any) => {
            this.addrole(item);
          },
        },
      ],
    },
  ];

  ngOnInit() {
    this.query();
    this.validate();
  }

  add() {
    this.username = '';
    this.password = '';
    this.checkPassword = '';
    this.isVisible = true;
  }

  edit(e) {
    this.password = '';
    this.checkPassword = '';
    this.uid = e.uid;
    this.username = e.username;
    this.isVisiblePassword = true;
  }
  delete(e) {
    this.isVisibledelete = true;
    this.uid = e.uid;
  }

  addrole(e) {
    this.isVisibleRole = true;
    this.uid = e.uid;
  }
  // 关闭编辑模态框事件
  handleCancel() {
    this.isVisible = false;
    this.isVisiblePassword = false;
    this.isVisibledelete = false;
    this.isVisibleRole = false;
  }
  query() {
    this.config.post(this.config.url + 'user/getUserList', { username: '' }).subscribe((res: any) => {
      this.data = res;
    });
  }

  // **
  /* 列表开关事件
   * @param e
   */
  switchChange(e) {
    this.user = e;
    this.config.post(this.config.url + 'user/BanUser', { uid: this.user.uid }).subscribe((res: any) => {
      this.user = res;
      let status = '';
      if (res.banning == false) {
        status = '已禁用！';
      } else {
        status = '已启用';
      }
      this.msg.success(res.username + '用户' + status);
      this.isVisible = false;
    });
  }

  // ========用户编辑表单验证=============
  /**
   *
   *  重复密码对比验证
   * @memberof SystemManageUserComponent
   */
  confirmationValidator = (control: FormControl): { [s: string]: boolean } => {
    if (!control.value) {
      return { required: true };
    } else if (control.value !== this.validateForm.controls.password.value) {
      return { confirm: true, error: true };
    }
    return {};
  };

  validate() {
    this.validateForm = this.fb.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]],
      checkPassword: [null, [Validators.required, this.confirmationValidator]],
    });
  }
  // 用户编辑模态框，添加提交事件
  handleOk() {
    // for (const i in this.validateForm.controls) {
    //   this.validateForm.controls[i].markAsDirty();
    //   this.validateForm.controls[i].updateValueAndValidity();
    // }
    this.config
      .post(this.config.url + 'user/addUser', { username: this.username, password: this.password })
      .subscribe((res: any) => {
        this.msg.success('新增用户成功');
        this.isVisible = false;
        // 刷新列表
        this.query();
      });
  }
  // 用户修改
  handleOkEdit() {
    this.config
      .post(this.config.url + 'user/editUser', { username: this.username, password: this.password, uid: this.uid })
      .subscribe((res: any) => {
        this.msg.success('修改密码成功');
        this.isVisiblePassword = false;
        // 刷新列表
        this.query();
      });
  }
  // 删除用户
  handledelete() {
    this.config.post(this.config.url + 'user/deleteUser?uid=' + this.uid, {}).subscribe((res: any) => {
      this.msg.success('删除成功');
      this.isVisibledelete = false;
      // 刷新列表
      this.query();
    });
  }
  // 分类角色
  handleRole() {}

  nzEvent(event: NzFormatEmitEvent): void {
    console.log(event);
  }

  // 键盘回车事件
  keydown(data) {
    if (data.keyCode === 13) {
      this.query();
    }
  }
}
