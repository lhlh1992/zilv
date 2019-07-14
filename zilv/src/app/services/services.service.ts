import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  public url='http://localhost:8080/';


  constructor(private http: HttpClient) { 

  }

  public token=''

  //设置token，作为和后端交互的令牌，通过请求头传到后端
  setToken(token){
      this.token=token
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
     'Authorization':this.token
    }
  )
  return this.http.post(url, param,{headers:headers}) 
}


}
