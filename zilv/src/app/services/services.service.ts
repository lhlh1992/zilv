import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { StorageService} from '../services/storage.service';
@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  public url='http://localhost:8080/';


  constructor(private http: HttpClient,
              private Storag:StorageService        
            ) { 

  }

 
    /**
  * post查询方式
  * @param url   请求地址
  * @param param   参数
  * @returns {any}  返回json格式数据
  */
 post(url, param) {
  let headers= new HttpHeaders(
    {'Content-Type':'application/json',
     'Authorization':this.Storag.getItem('Token')
    }
  )
  return this.http.post(url, param,{headers:headers}) 
}


}
