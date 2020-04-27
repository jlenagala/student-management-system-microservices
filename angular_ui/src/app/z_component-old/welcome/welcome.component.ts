import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from 'src/app/z_service-old/welcome-old/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
 // employeeDetails:string[];
  name = ''
  //ActivatedRoute
  constructor(
    private route: ActivatedRoute,
    private welcomeDataService: WelcomeDataService) {

  }
  ngOnInit() {
    this.name = this.route.snapshot.params['name']
  }
  // getWelcomeMessage() {
  //   //this.welcomeDataService.excuteHelloWorldService()
  //   console.log(this.welcomeDataService.excuteHelloWorldService());
  //   this.welcomeDataService.excuteHelloWorldService().subscribe(
  //     response => this.handleSuccessfulResponse(response),
  //    // error=>this.handleErrorResponse(error)
  //   );

  //   console.log("last line of get welcome")
  //   //console.log("get welcome");
  // }


  // handleSuccessfulResponse(response){
  //   this.employeeDetails=response.message;
  //     //console.log(response);
  //     //console.log(response.message);
  // }
  // handleErrorResponse(error){
  //   // this.employeeDetails=error.message;
  
  // }

}
