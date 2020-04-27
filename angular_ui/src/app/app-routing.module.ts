import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './z_component-old/welcome/welcome.component';
import { ErrorComponent } from './core/error/error.component';
import { ListUsersComponent } from './z_component-old/user/list-users/list-users.component';
import { LogoutComponent } from './core/logout/logout.component';
import { RouteGuardService } from './core/routeService/route-guard.service';
import { UpdateUserComponent } from './z_component-old/user/update-user/update-user.component';
import { HomeComponent } from './core/home/home.component';
import { RegisterComponent } from './register/component/register.component';
import { ProfileComponent } from './profile/component/profile.component';
import { BoardUserComponent } from './auth/component/board-user/board-user.component';
import { BoardModeratorComponent } from './auth/component/board-moderator/board-moderator.component';
import { BoardAdminComponent } from './auth/component/board-admin/board-admin.component';
import { LogingComponent } from './auth/component/loging/loging.component';
import { CourseListComponent } from './course/component/course-list/course-list.component';
import { CourseDetailsComponent } from './course/component/course-details/course-details.component';
import { StudentListComponent } from './student/component/student-list/student-list.component';
import { StudentDetailsComponent } from './student/component/student-details/student-details.component';
import { AllocationDetailsComponent } from './allocation/component/allocation-details/allocation-details.component';
import { AllocationListComponent } from './allocation/component/allocation-list/allocation-list.component';


const routes: Routes = [
  {path:'',component:LogingComponent},
  {path:'login',component:LogingComponent},
  {path:'welcome/:name', component:WelcomeComponent,canActivate:[RouteGuardService]},
  {path:'users', component:ListUsersComponent,canActivate:[RouteGuardService]},
  {path:'logout', component:LogoutComponent,canActivate:[RouteGuardService]},
  {path:'users/:id', component:UpdateUserComponent,canActivate:[RouteGuardService]},
  
  {path:'courses', component:CourseListComponent,canActivate:[RouteGuardService]},
  {path:'courses/:id', component:CourseDetailsComponent,canActivate:[RouteGuardService]},
  {path:'students', component:StudentListComponent,canActivate:[RouteGuardService]},
  {path:'students/:id', component:StudentDetailsComponent,canActivate:[RouteGuardService]},
  {path:'allocations', component:AllocationListComponent,canActivate:[RouteGuardService]},
  {path:'allocations/:id1/:id2', component:AllocationDetailsComponent,canActivate:[RouteGuardService]},
  

  { path: 'home', component: HomeComponent },
  //{ path: 'loging', component:LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  {path:'**',component:ErrorComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
