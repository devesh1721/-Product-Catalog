import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { User } from '../entity/user';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }
  baseUrl: string = "http://127.0.0.1:9099";
  registerUser(data: User) {
    return this.http.post(`${this.baseUrl}/user/`, data);
  }
}
