import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  public url='http://localhost:8080/';


  constructor(private http: HttpClient) { 

  }

    /**
  * post查询方式
  * @param url   请求地址
  * @param param   参数
  * @returns {any}  返回json格式数据
  */
 post(url, param, callback) {
  let headers = {
    headers: new HttpHeaders({
      'Content-Type': "application/json"
    })
  };
  this.http
    .post(url,
      JSON.stringify(param), headers)
    .subscribe(function (res) {
      callback('success', res)
    }, function (err) {
      callback('error', err)
    });
}
}
