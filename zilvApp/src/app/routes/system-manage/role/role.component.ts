import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ServicesService } from '../../../httpService/service.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NzMessageService, NzModalService } from 'ng-zorro-antd';
@Component({
  selector: 'app-system-manage-role',
  templateUrl: './role.component.html',
})
export class SystemManageRoleComponent implements OnInit {
  data = [];

  validateForm: FormGroup; // 表单的验证

  // 用户编辑模态框
  isVisible = false;

  isVisibledelete = false;
  // ==字段双向绑定====
  id = '';
  rolename = '';
  roleCode = '';
  description = '';
  available = '';
  // =====判断是添加还是修改======
  isAddOrEdit = '';

  @ViewChild('st', { static: false }) st: STComponent;
  columns: STColumn[] = [
    { title: '角色名称', index: 'rolename' },
    { title: '角色描述', index: 'description' },
    { title: '创建时间', index: 'create_time' },
    { title: '创建人', index: 'create_user' },
    { title: '最后修改时间', index: 'update_time' },
    { title: '最后修改人', index: 'update_user' },
    { title: '是否可用', index: 'available', renderTitle: 'customTitle', render: 'custom' },
    {
      title: '操作',
      buttons: [
        {
          text: '编辑',
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
          text: '分配权限',
          click: (item: any) => {},
        },
      ],
    },
  ];

  constructor(
    private http: _HttpClient,
    private modal: ModalHelper,
    private config: ServicesService,
    private fb: FormBuilder,
    private msg: NzMessageService,
  ) {}

  ngOnInit() {
    this.query();
    this.validate();
  }
  // 表单验证
  validate() {
    this.validateForm = this.fb.group({
      rolename: [null, [Validators.required]],
      roleCode: [null, [Validators.required]],
      description: [null],
    });
  }

  query() {
    this.config.post(this.config.url + 'role/getRoleList', { rolename: '' }).subscribe((res: any) => {
      this.data = res;
    });
  }

  add() {
    this.roleCode = '';
    this.rolename = '';
    this.description = '';
    this.isAddOrEdit = 'add';
    this.isVisible = true;
  }

  edit(e) {
    console.log(e);
    this.roleCode = e.roleCode;
    this.rolename = e.rolename;
    this.description = e.description;
    this.id = e.rid;
    this.available = e.available;
    this.isAddOrEdit = 'edit';
    this.isVisible = true;
  }

  delete(e) {
    this.isVisibledelete = true;
    this.id = e.rid;
  }
  handleCancel() {
    this.isVisible = false;
  }

  handleOk() {
    if (this.isAddOrEdit == 'add') {
      this.config
        .post(this.config.url + 'role/addRole', {
          rolename: this.rolename,
          roleCode: this.roleCode,
          description: this.description,
        })
        .subscribe((res: any) => {
          this.msg.success('新增角色成功');
          this.isVisible = false;
          // 刷新列表
          this.query();
        });
    } else {
      this.config
        .post(this.config.url + 'role/editRole', {
          rid: this.id,
          available: this.available,
          rolename: this.rolename,
          roleCode: this.roleCode,
          description: this.description,
        })
        .subscribe((res: any) => {
          this.msg.success('修改角色成功');
          this.isVisible = false;
          // 刷新列表
          this.query();
        });
    }
  }
  // 单条删除操作
  handledelete() {
    this.config.post(this.config.url + 'role/deleteRole?rid=' + this.id, {}).subscribe((res: any) => {
      this.msg.success('删除成功');
      this.isVisibledelete = false;
      // 刷新列表
      this.query();
    });
  }

  switchChange(e) {
    this.config.post(this.config.url + 'role/BanRole', { rid: e.rid }).subscribe((res: any) => {
      let status = '';
      if (res.available == false) {
        status = '已禁用！';
      } else {
        status = '已启用';
      }
      this.msg.success(res.rolename + '角色' + status);
      this.isVisible = false;
    });
  }

  // 键盘回车事件
  keydown(data) {
    if (data.keyCode === 13) {
      this.query();
    }
  }
}
