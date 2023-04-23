import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login.service';
import { MatSidenav } from '@angular/material/sidenav';
import { BreakpointObserver } from '@angular/cdk/layout';
import { delay, filter } from 'rxjs/operators';
import { NavigationEnd} from '@angular/router';
import { UntilDestroy, untilDestroyed } from '@ngneat/until-destroy';
;
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  constructor(public loginService:LoginService,private route:Router,private observer: BreakpointObserver) { }

  public data:string = "login"; 

  ngOnInit(): void {
    if(this.loginService.isLoggedIn()) {
      this.data = "logout"; 
    }
  }
  logout(){
    console.log("This is the logout");
    this.loginService.logout();
    this.data="login";
    this.route.navigate(["login"]);
  }

  ngAfterViewInit() {
    
  }




}
