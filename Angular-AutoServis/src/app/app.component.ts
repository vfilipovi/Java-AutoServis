import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { LanguageEnum } from './constants/language.enum';
import {LoginService} from "./login/login.service";
import {UserService} from "./user/user.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Angular-AutoServis';
  currentLanguage: string;
  private translateService;

  constructor(
    private loginService: LoginService,
    public userService: UserService,
    private router: Router,
    private translate: TranslateService) {
    translate.setDefaultLang('hr');
    this.translateService = TranslateService;
  }

  ngOnInit(): void {
  }

  useLanguage(language: string) {
      this.translate.use(language);
  }

  logout() {
    this.loginService.logout();
    this.userService.currentUser = null;
    this.router.navigate(['/login']);
  }

  isUserLoggedIn(): boolean {
    return !!this.userService.currentUser;
  }

}


