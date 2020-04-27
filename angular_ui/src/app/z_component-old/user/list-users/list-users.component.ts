import { Component, OnInit } from '@angular/core';
import { UserDataService } from 'src/app/z_service-old/user-old/user-data.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

export class User {
  constructor(
    public id: number,
    public nic: number,
    public name: string,
    public dob: Date,
    public gender: string,
    public designation: string,
    public currentStatus: string,
    // public telephones: [ 
    //                       public number: string
    //                     ],

    public addresses: {
      lane1: string,
      lane2: string,
      city: string
    }
  ) {

  }
}
@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {
  // users=[
  //   new User(1,'Janani','Lenagala','jan@gamil.com',new Date()),
  //   new User(2,'Aaaa','ssss','jasaan@gamil.com',new Date()),
  //   new User(3,'vvvvv','ttttt','vtvt@gamil.com',new Date())

  // ]
  users: User[];
  message:string
  constructor(
    private userDataService: UserDataService,
    private router:Router
  ) {

  }

  ngOnInit(): void {
    this.loadUsers();

  }

  loadUsers(){
    this.userDataService.fetchAllData().subscribe(
      response => {
        console.log(response);
        this.users = response;}
  );
  }

  deleteUsers(id){
   // console.log(`Deleted ${id}`)
   this.userDataService.deleteData(id).subscribe(
    response => {
      console.log(response);
      this.message = (`Deleted user ${id}`);
      this.loadUsers();}
      
);
  }

  updateUsers(id){
    console.log(`Updated ${id}`);
    this.router.navigate(['users',id])

  }
  addUsers(){
    this.router.navigate(['users',-1])
  }
}


