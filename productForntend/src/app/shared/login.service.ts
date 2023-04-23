import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Token } from '../entity/token';
import { User } from '../entity/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }
  baseUrl="http://127.0.0.1:9099"
  //Generate token
  public generateToken(loginData: User) {
    return this.http.post<Token>(`${this.baseUrl}/token`, loginData);
  }

  public saveToken(token: string) {
    sessionStorage.setItem("token", token);
    return true;
  }

  public isLoggedIn() {
    let tokenStr = sessionStorage.getItem("token");
    if (tokenStr == undefined || tokenStr == '' || tokenStr == null) {
      return false;
    } else {
      return true;
    }
  }

  public logout() {
    sessionStorage.removeItem("token");
    return true;
  }

  public getToken() {
    return sessionStorage.getItem("token");
  }
   
  public setUserName(username:string){
    sessionStorage.setItem("username",username);
  }
}
