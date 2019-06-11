import { Component, OnInit, ViewChild } from '@angular/core';
import { _HttpClient, ModalHelper } from '@delon/theme';
import { STColumn, STComponent } from '@delon/abc';
import { SFSchema } from '@delon/form';
import { ActivatedRoute,Router} from '@angular/router';
import { ServicesService} from '../../../services/services.service';
@Component({
  selector: 'app-guanli-details',
  templateUrl: './details.component.html',
})
export class GuanliDetailsComponent implements OnInit {
  data=[]

  constructor(private http: _HttpClient, private modal: ModalHelper,private activatedRoute: ActivatedRoute,private config:ServicesService) { 
  }

  ngOnInit(): void { 
     console.log(this.data)
  }

  add() {
    // this.modal
    //   .createStatic(FormEditComponent, { i: { id: 0 } })
    //   .subscribe(() => this.st.reload());
  }

  downExcel(){
          let d = this.data;
          console.log(JSON.stringify(d))
          this.http.post(this.config.url+'Diary/downExcel',
          {'diary':JSON.stringify(d)}
          ) .subscribe((res: any) => {
                    console.log(res)
                    this.data=res;      
      });
  } 

}
