import { Component, OnInit } from '@angular/core';
import { AuthenticationSampleService } from 'src/app/z_service-old/authentication/authentication-sample.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  //isUserLoggedIn: boolean=false;
  constructor(public authenticationSampleService
    :AuthenticationSampleService) { }

  ngOnInit(): void {
    //this.isUserLoggedIn=this.authenticationSampleService.isUserLoggedIn();
  }

}
