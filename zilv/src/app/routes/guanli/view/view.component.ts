import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-guanli-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class GuanliViewComponent implements OnInit {
  aa=''
  url = `/user`;
  searchSchema: SFSchema = {
    properties: {
      no: {
        type: 'string',
        title: '编号'
      }
    }
  };

  
  @ViewChild('st') st: STComponent;
  columns: STColumn[] = [
    { title: '编号', index: 'no' },
    { title: '调用次数', type: 'number', index: 'callNo' },
    { title: '头像', type: 'img', width: '50px', index: 'avatar' },
    { title: '时间', type: 'date', index: 'updatedAt' },
    {
      title: '',
      buttons: [
        // { text: '查看', click: (item: any) => `/form/${item.id}` },
        // { text: '编辑', type: 'static', component: FormEditComponent, click: 'reload' },
      ]
    }
  ];
   
  constructor(private http: _HttpClient, private modal: ModalHelper,private activatedRoute: ActivatedRoute) { 
    activatedRoute.queryParams.subscribe(queryParams => {
      let productId = queryParams.productId;
      let title = queryParams.title;

      this.aa = queryParams.productId;
  });
  }

  ngOnInit() { 
  
  }

  add() {
    // this.modal
    //   .createStatic(FormEditComponent, { i: { id: 0 } })
    //   .subscribe(() => this.st.reload());
  }

}
