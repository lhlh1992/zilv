import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
// 储蓄服务类，关闭浏览器后，数据依然保存
export class StorageService {
  constructor() {}

  setlocalStorage(key, value) {
    localStorage.setItem(key, JSON.stringify(value));
  }

  getItem(key) {
    return JSON.parse(localStorage.getItem(key));
  }

  removeItem(key) {
    localStorage.removeItem(key);
  }
}
