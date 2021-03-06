import { Injectable, Injector, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { zip } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { MenuService, SettingsService, TitleService, ALAIN_I18N_TOKEN } from '@delon/theme';
import { DA_SERVICE_TOKEN, ITokenService } from '@delon/auth';
import { ACLService } from '@delon/acl';
import { TranslateService } from '@ngx-translate/core';
import { I18NService } from '../i18n/i18n.service';

import { NzIconService } from 'ng-zorro-antd';
import { ICONS_AUTO } from '../../../style-icons-auto';
import { ICONS } from '../../../style-icons';
import { StorageService } from '../../httpService/storage.service';
/**
 * 用于应用启动时
 * 一般用来获取应用所需要的基础数据等
 */
@Injectable()
export class StartupService {
  constructor(
    iconSrv: NzIconService,
    private menuService: MenuService,
    private translate: TranslateService,
    @Inject(ALAIN_I18N_TOKEN) private i18n: I18NService,
    private settingService: SettingsService,
    private aclService: ACLService,
    private titleService: TitleService,
    @Inject(DA_SERVICE_TOKEN) private tokenService: ITokenService,
    private httpClient: HttpClient,
    private injector: Injector,
    private Storag: StorageService,
  ) {
    iconSrv.addIcon(...ICONS_AUTO, ...ICONS);
  }

  private viaHttp(resolve: any, reject: any) {
    zip(
      this.httpClient.get(`assets/tmp/i18n/${this.i18n.defaultLang}.json`),
      this.httpClient.get('assets/tmp/app-data.json'),
    )
      .pipe(
        // 接收其他拦截器后产生的异常消息
        catchError(([langData, appData]) => {
          resolve(null);
          return [langData, appData];
        }),
      )
      .subscribe(
        ([langData, appData]) => {
          // setting language data
          this.translate.setTranslation(this.i18n.defaultLang, langData);
          this.translate.setDefaultLang(this.i18n.defaultLang);

          // application data
          const res: any = appData;
          // 应用信息：包括站点名、描述、年份
          this.settingService.setApp(res.app);
          // 用户信息：包括姓名、头像、邮箱地址
          this.settingService.setUser(res.user);
          // ACL：设置权限为全量
          this.aclService.setFull(false);

          // 初始化菜单
          this.menuService.add(res.menu);
          // 设置页面标题的后缀
          this.titleService.suffix = res.app.name;
        },
        () => {},
        () => {
          resolve(null);
        },
      );
  }

  private viaMockI18n(resolve: any, reject: any) {
    this.httpClient.get(`assets/tmp/i18n/${this.i18n.defaultLang}.json`).subscribe(langData => {
      this.translate.setTranslation(this.i18n.defaultLang, langData);
      this.translate.setDefaultLang(this.i18n.defaultLang);

      this.viaMock(resolve, reject);
    });
  }

  private viaMock(resolve: any, reject: any) {
    // const tokenData = this.tokenService.get();
    // if (!tokenData.token) {
    //   this.injector.get(Router).navigateByUrl('/passport/login');
    //   resolve({});
    //   return;
    // }
    // mock
    const app: any = {
      name: `ng-alain`,
      description: `Ng-zorro admin panel front-end framework`,
    };
    const user: any = {
      name: 'Admin',
      avatar: './assets/tmp/img/liuhui.jpg',
      email: 'cipchk@qq.com',
      token: '123456789',
    };
    // 应用信息：包括站点名、描述、年份
    this.settingService.setApp(app);
    // 用户信息：包括姓名、头像、邮箱地址
    this.settingService.setUser(user);
    // ACL：设置权限为全量
    this.aclService.setFull(false);
    // MLGB的，先给本地缓存的menu里放个值，要不一开始进入项目就保存，我真草了个DJ，一开始不这样先赋值也是可以的，某一天突然不行，只能这样处理了。CNM
    // this.Storag.setlocalStorage('menu',"11111")

    // 初始化菜单
    console.log('==================');
    console.log(JSON.parse(this.Storag.getItem('menu')));
    this.menuService.add([
      {
        text: '',
        // JSON.parse(this.Storag.getItem("menu"))
        children: JSON.parse(this.Storag.getItem('menu')),
        // [
        //   {
        //     text: '每日记录1',
        //     children: [{ text: '日记', link: '/guanli/guanliPage' }],
        //   },
        //   {
        //     text: '系统管理1',
        //     children: [{ text: '字典管理', link: '/sys/dicitem' }, { text: '用户管理', link: '/sys/user' }],
        //   },
        //   {
        //     text: '每日记录2',
        //     children: [{ text: '日记', link: '/diary/guanliPage' }],
        //   },
        // ],
      },
    ]);
    // 设置页面标题的后缀
    this.titleService.suffix = app.name;

    resolve({});
  }

  jsonToMap(jsonStr) {
    return new Map(JSON.parse(jsonStr));
  }
  load(): Promise<any> {
    // only works with promises
    // https://github.com/angular/angular/issues/15088
    return new Promise((resolve, reject) => {
      // http
      // this.viaHttp(resolve, reject);
      // mock：请勿在生产环境中这么使用，viaMock 单纯只是为了模拟一些数据使脚手架一开始能正常运行
      this.viaMockI18n(resolve, reject);
    });
  }
}
