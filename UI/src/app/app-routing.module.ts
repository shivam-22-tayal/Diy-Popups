import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './_guards/auth.guard';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import {UserProfileComponent } from './user-profile/user-profile.component';


const routes: Routes = [
  {path: '', component: LandingpageComponent},
  {path: 'landingpage', component: LandingpageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'user-dashboard', component: UserDashboardComponent},
   {path: 'user-profile',component:UserProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
