import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from "../app/user-auth/signup/signup.component"
import { LoginComponent } from "../app/user-auth/login/login.component"
import { UserdashboardComponent } from './dashboard/userdashboard/userdashboard.component';
import { UserguardGuard } from './shared/userguard.guard';
import { ProductDetailsComponent } from './product/product-details/product-details.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

const routes: Routes = [
  {
    path: "signup",
    component: SignupComponent,
    pathMatch: 'full'
  },
  {
    path: "login",
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path:"",
    component:UserdashboardComponent,
    pathMatch:"full"
  },
  {
    path:"details/:productId",
    component:ProductDetailsComponent,
    canActivate:[UserguardGuard]
  },
  {
       path: '**', pathMatch: 'full', 
       component:  PagenotfoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
