import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  public url='http://localhost:8080/';


  constructor(private http: HttpClient) { 

  }

//     /**
//   * post查询方式
//   * @param url   请求地址
//   * @param param   参数
//   * @returns {any}  返回json格式数据
//   */
//  post(url, param, callback) {
//   let headers= new HttpHeaders(
//     {'Content-Type':'application/json',
//      'Authorization':'eqweqwe'
//     }
//   )

//   this.http.post(url, param,{headers:headers}) 
//     .subscribe(function (res) {  
//       callback('success', res)
//     }, function (err) {
//       callback('error', err)
//     });
// }


    /**
  * post查询方式
  * @param url   请求地址
  * @param param   参数
  * @returns {any}  返回json格式数据
  */
 post(url, param) {
  let headers= new HttpHeaders(
    {'Content-Type':'application/json',
     'Authorization':'df4b5474-fd86-4a02-9078-4d4977a83356'
    }
  )
  return this.http.post(url, param,{headers:headers}) 
}


}
