import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ServicesService} from '../../../services/services.service';


@Component({
  selector: 'app-system-manage-user',
  templateUrl: './user.component.html',
})
export class SystemManageUserComponent implements OnInit {
 
  data = []
  @ViewChild('st') st: STComponent;
  columns: STColumn[] = [
    { title: '用户名', index: 'username' },
    {
      title: '',
      buttons: [
        { text: '查看'},
        { text: '编辑'},
      ]
    }
  ];

  constructor(private http: _HttpClient,
               private modal: ModalHelper,
               private config:ServicesService) { }

  ngOnInit() {
        this.query()
   }

  add() {
   
  }

  query(){
    this.config.post(this.config.url+'user/getUserList',
    {username:''}
    ) .subscribe((res: any) => {       
                    this.data = res;
      });
  }

  

}
