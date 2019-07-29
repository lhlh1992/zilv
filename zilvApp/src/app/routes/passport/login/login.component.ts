import { SettingsService, _HttpClient, MenuService } from '@delon/theme';
import { Component, OnDestroy, Inject, Optional } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzMessageService, NzModalService } from 'ng-zorro-antd';
import { ServicesService } from '../../../httpService/service.service';
import { StorageService } from '../../../httpService/storage.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ACLService } from '@delon/acl';
import { SocialService, SocialOpenType, ITokenService, DA_SERVICE_TOKEN } from '@delon/auth';
import { ReuseTabService } from '@delon/abc';
import { environment } from '@env/environment';
import { StartupService } from '@core';
import { HttpHandler } from '@angular/common/http';
import { Token } from '@angular/compiler';

@Component({
  selector: 'passport-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less'],
  providers: [SocialService],
})
export class UserLoginComponent implements OnDestroy {
  constructor(
    fb: FormBuilder,
    modalSrv: NzModalService,
    private router: Router,
    private settingsService: SettingsService,
    private socialService: SocialService,
    @Optional()
    @Inject(ReuseTabService)
    private reuseTabService: ReuseTabService,
    @Inject(DA_SERVICE_TOKEN) private tokenService: ITokenService,
    private startupSrv: StartupService,
    public http: _HttpClient,
    public msg: NzMessageService,
    private config: ServicesService,
    private Storag: StorageService,
    private menuService: MenuService,
    private aclService: ACLService,
  ) {
    this.form = fb.group({
      userName: [null, [Validators.required, Validators.minLength(3)]],
      password: [null, Validators.required],
      mobile: [null, [Validators.required, Validators.pattern(/^1\d{10}$/)]],
      captcha: [null, [Validators.required]],
      remember: [true],
    });
    modalSrv.closeAll();
  }

  // #region fields

  get userName() {
    return this.form.controls.userName;
  }
  get password() {
    return this.form.controls.password;
  }
  get mobile() {
    return this.form.controls.mobile;
  }
  get captcha() {
    return this.form.controls.captcha;
  }
  form: FormGroup;
  error = '';
  type = 0;

  // #region get captcha

  count = 0;
  interval$: any;

  // #endregion

  switch(ret: any) {
    this.type = ret.index;
  }

  getCaptcha() {
    if (this.mobile.invalid) {
      this.mobile.markAsDirty({ onlySelf: true });
      this.mobile.updateValueAndValidity({ onlySelf: true });
      return;
    }
    this.count = 59;
    this.interval$ = setInterval(() => {
      this.count -= 1;
      if (this.count <= 0) clearInterval(this.interval$);
    }, 1000);
  }

  // #endregion

  submit() {
    this.error = '';
    if (this.type === 0) {
      this.userName.markAsDirty();
      this.userName.updateValueAndValidity();
      this.password.markAsDirty();
      this.password.updateValueAndValidity();
      if (this.userName.invalid || this.password.invalid) return;
    } else {
      this.mobile.markAsDirty();
      this.mobile.updateValueAndValidity();
      this.captcha.markAsDirty();
      this.captcha.updateValueAndValidity();
      if (this.mobile.invalid || this.captcha.invalid) return;
    }

    // 默认配置中对所有HTTP请求都会强制 [校验](https://ng-alain.com/auth/getting-started) 用户 Token
    // 然一般来说登录请求不需要校验，因此可以在请求URL加上：`/login?_allow_anonymous=true` 表示不触发用户 Token 校验

    this.http
      .post(this.config.url + '/login', {
        username: this.userName.value,
        password: this.password.value,
      })
      .subscribe((res: any) => {
        if (res.msg !== 'success') {
          this.error = res.count;
          return;
        }
        // 清空路由复用信息
        this.reuseTabService.clear();
        // 设置用户Token信息
        this.Storag.setlocalStorage('Token', res.user.token);
        this.Storag.setlocalStorage('menu', res.user.menu);
        // this.Storag.setlocalStorage('menu',res.user.menu)
        this.tokenService.set(res.user);
        // 初始化菜单   (邪门了，之前这里加入路由的原因，是因为startup里，初始化的时候获取的缓存为空会报错，但是加在这里，
        // 刷新页面菜单会消失。现在又改为加在startup里，报错问题也没有了，不知道为啥)
        // const menu = [
        //   {
        //     text: '',
        //     children: JSON.parse(res.user.menu),
        //   },
        // ];
        // this.menuService.add(menu);
        // ACL：设置权限为全量
        this.aclService.setFull(false);
        const str = ['admin1'];
        this.aclService.setRole(str);
        console.log(this.aclService.data);
        // 重新获取 StartupService 内容，我们始终认为应用信息一般都会受当前用户授权范围而影响
        console.log(this.tokenService.referrer.url);
        this.startupSrv.load().then(() => {
          let url = this.tokenService.referrer.url || '/';
          if (url.includes('/passport')) url = '/';
          this.router.navigateByUrl(url);
        });
      });
  }

  loginCallback() {
    console.log('oooo');
  }

  // #region social

  open(type: string, openType: SocialOpenType = 'href') {
    let url = ``;
    let callback = ``;
    if (environment.production) {
      callback = 'https://ng-alain.github.io/ng-alain/#/callback/' + type;
    } else {
      callback = 'http://localhost:4200/#/callback/' + type;
    }
    switch (type) {
      case 'auth0':
        url = `//cipchk.auth0.com/login?client=8gcNydIDzGBYxzqV0Vm1CX_RXH-wsWo5&redirect_uri=${decodeURIComponent(
          callback,
        )}`;
        break;
      case 'github':
        url = `//github.com/login/oauth/authorize?client_id=9d6baae4b04a23fcafa2&response_type=code&redirect_uri=${decodeURIComponent(
          callback,
        )}`;
        break;
      case 'weibo':
        url = `https://api.weibo.com/oauth2/authorize?client_id=1239507802&response_type=code&redirect_uri=${decodeURIComponent(
          callback,
        )}`;
        break;
    }
    if (openType === 'window') {
      this.socialService
        .login(url, '/', {
          type: 'window',
        })
        .subscribe(res => {
          if (res) {
            this.settingsService.setUser(res);
            this.router.navigateByUrl('/');
          }
        });
    } else {
      this.socialService.login(url, '/', {
        type: 'href',
      });
    }
  }

  // #endregion

  ngOnDestroy(): void {
    if (this.interval$) clearInterval(this.interval$);
  }
}
