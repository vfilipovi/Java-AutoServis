import { Component, OnInit } from '@angular/core';
import {UserService} from '../../user/user.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  constructor(public userService: UserService) {}

  ngOnInit(): void {
  }

  isUserLoggedIn(): boolean {
    return !!this.userService.currentUser;
  }

}


