import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/z_component-old/user/list-users/list-users.component';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  constructor(
    private http: HttpClient
  ) { }

  fetchAllData() {
    //console.log("Exexute excute Hello World Service");
    return this.http.get<User[]>('http://localhost:8393/services/employees')

  }

  deleteData(id) {
    return this.http.delete(`http://localhost:8393/services/employees/${id}`)

  }

  fetchData(id) {
    //console.log("Exexute excute Hello World Service");
    return this.http.get<User>(`http://localhost:8393/services/employees/${id}`)

  }

  updateData(user) {
    return this.http.put('http://localhost:8393/services/employees', user)
  }

  createData(user){
    return this.http.post('http://localhost:8393/services/employees', user)
  }
}
