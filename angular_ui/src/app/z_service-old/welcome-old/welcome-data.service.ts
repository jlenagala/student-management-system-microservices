import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
 
export class Hello{
  constructor(
    //public message: string,
    public addresses: string,
    public currentStatus: string,
    public designation: string,
    public dob: Date,
    public gender: string,
    public id: number,
    public name: string,
    public nic: string,
    public telephones: Array<string>
    
    
    
    ){

  }

}

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    private http: HttpClient
  ) { }

  excuteHelloWorldService(){
    //console.log("Exexute excute Hello World Service");
     // return this.http.get<Hello[]>('http://localhost:8393/services/employees')
      
    }

}
