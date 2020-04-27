import { Component, OnInit } from '@angular/core';
import { UserDataService } from 'src/app/z_service-old/user-old/user-data.service';
import { User } from '../list-users/list-users.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
id:number;
user:User;
  constructor(
    private userDataService:UserDataService,
    private route:ActivatedRoute,
    private router:Router

  ) { }

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(){
    this.id=this.route.snapshot.params['id'];
    //this.user=new User(this.id,"","","","","",",new Date());//default values to user object

    if(this.id!=-1){
        this.userDataService.fetchData(this.id).subscribe(
        data =>this.user = data
  );
    }
   
  }
  saveUsers(){

    if(this.id===-1){
      this.userDataService.createData(this.user).subscribe(
        data =>{
          console.log(data);
            this.router.navigate(['users']);
        }
    );
    }else{
      this.userDataService.updateData(this.user).subscribe(
        data =>{
          console.log(data);
            this.router.navigate(['users']);
        }
    );
    }
    
}
}
