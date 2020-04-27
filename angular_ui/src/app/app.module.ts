import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './z_component-old/welcome/welcome.component';
import { ErrorComponent } from './core/error/error.component';
import { ListUsersComponent } from './z_component-old/user/list-users/list-users.component';
import { MenuComponent } from './z_component-old/menu/menu.component';
import { FooterComponent } from './core/footer/footer.component';
import { LogoutComponent } from './core/logout/logout.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { UpdateUserComponent } from './z_component-old/user/update-user/update-user.component';
import { RegisterComponent } from './register/component/register.component';
import { HomeComponent } from './core/home/home.component';
import { ProfileComponent } from './profile/component/profile.component';
import { BoardAdminComponent } from './auth/component/board-admin/board-admin.component';
import { BoardModeratorComponent } from './auth/component/board-moderator/board-moderator.component';
import { BoardUserComponent } from './auth/component/board-user/board-user.component';
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { LogingComponent } from './auth/component/loging/loging.component';
import { CourseListComponent } from './course/component/course-list/course-list.component';
import { CourseDetailsComponent } from './course/component/course-details/course-details.component';
import { AllocationDetailsComponent } from './allocation/component/allocation-details/allocation-details.component';
import { AllocationListComponent } from './allocation/component/allocation-list/allocation-list.component';
import { StudentDetailsComponent } from './student/component/student-details/student-details.component';
import { StudentListComponent } from './student/component/student-list/student-list.component';



@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    ErrorComponent,
    ListUsersComponent,
    MenuComponent,
    FooterComponent,
    LogoutComponent,
    UpdateUserComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    LogingComponent,
    CourseListComponent,
    CourseDetailsComponent,
    StudentDetailsComponent,
    StudentListComponent,
    AllocationDetailsComponent,
    AllocationListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
