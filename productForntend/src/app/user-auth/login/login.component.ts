import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from "@angular/forms"
import { LoginService } from 'src/app/shared/login.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { User } from 'src/app/entity/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User | undefined;
  constructor(private loginService: LoginService, private http: HttpClient, private route: Router) { }

  ngOnInit(): void {
  }

  public loginForm = new FormGroup({
    username: new FormControl("", [Validators.required, Validators.email]),
    password: new FormControl("", [Validators.required])
  });

  loginUser() {
    console.log(this.loginForm.value);
    this.loginService.generateToken(<User>this.loginForm.value).subscribe(data => {
      this.loginService.saveToken(data.token);
      this.loginService.setUserName(<string>this.loginForm.value.username);
      this.route.navigate([""]);
    }, (error) => {
      alert("Invalid Credential");
      console.log("Some error happend" + error);
    })
  }

  get username() {
    return this.loginForm.get("username");
  }
  get password() {
    return this.loginForm.get("username");
  }
}
