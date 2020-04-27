import { Component, OnInit } from '@angular/core';
import { AuthenticationSampleService } from 'src/app/z_service-old/authentication/authentication-sample.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authenticationSampleService : AuthenticationSampleService) { }

  ngOnInit(): void {
    this.authenticationSampleService.logout();
  }

}
