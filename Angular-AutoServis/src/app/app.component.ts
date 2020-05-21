import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { LanguageEnum } from './constants/language.enum';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Angular-AutoServis';
  currentLanguage: string;
  private translateService;

  constructor(private translate: TranslateService) {
    translate.setDefaultLang('hr');
    this.translateService = TranslateService;
  }

  ngOnInit(): void {
  }

  useLanguage(language: string) {
      this.translate.use(language);
  }
}


