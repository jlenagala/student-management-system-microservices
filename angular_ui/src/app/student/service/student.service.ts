import { Injectable } from '@angular/core';
import { Student } from '../model/student';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  constructor(
    private http: HttpClient
  ) { }
  
  fetchAllData() {
    //console.log("Exexute excute Hello World Service");
    return this.http.get<Student[]>('http://localhost:8494/services/students')

  }

  deleteData(id) {
    return this.http.delete(`http://localhost:8494/services/students/${id}`)

  }

  fetchData(id) {
    //console.log("Exexute excute Hello World Service");
    return this.http.get<Student>(`http://localhost:8494/services/students/${id}`)

  }

  updateData(student) {
    
    return this.http.put('http://localhost:8494/services/students', student)
  }

  createData(student){
    //console.log(student);
    return this.http.post('http://localhost:8494/services/students', student)
  }
}