import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ActivatedRoute,Router} from '@angular/router';
@Component({
  selector: 'app-guanli-details',
  templateUrl: './details.component.html',
})
export class GuanliDetailsComponent implements OnInit {
  data=[]

  constructor(private http: _HttpClient, private modal: ModalHelper,private activatedRoute: ActivatedRoute) { 
  }

  ngOnInit(): void { 
     console.log(this.data)
  }

  add() {
    // this.modal
    //   .createStatic(FormEditComponent, { i: { id: 0 } })
    //   .subscribe(() => this.st.reload());
  }

}
