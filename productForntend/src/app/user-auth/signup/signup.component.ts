import { Component, OnInit } from '@angular/core';
import {FormControl,FormGroup, Validators} from "@angular/forms"
import { Router } from '@angular/router';
import { User } from 'src/app/entity/user';
import {UserServiceService} from "src/app/shared/user-service.service"

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserServiceService,private route:Router) { }

  ngOnInit(): void {
  }
  
  public user  = new FormGroup({
    email: new FormControl("",[Validators.required]),
    firstName: new FormControl("",[Validators.required]),
    lastName: new FormControl("",[Validators.required]),
    password: new FormControl("",[Validators.required])
  });

   registerUser(){
     this.userService.registerUser(<User>this.user.value).subscribe((data)=>{
      alert("User Resgister Sucessfully");
      this.route.navigate(["/login"]);
     },(error)=>{
      alert("User not Resgistered");
     })
   }

   get email(){
    return this.user.get("email");
   }

   get firstName(){
    return this.user.get("firstName");
   }
   
   get lastName(){
    return this.user.get("lastName");
   }

   
   get password(){
    return this.user.get("password");
   }


}
