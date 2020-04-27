import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(
    private http: HttpClient
  ) { }
  
  fetchAllData() {
    //console.log("Exexute excute Hello World Service");
    return this.http.get<Course[]>('http://localhost:8585/services/courses')

  }

  deleteData(id) {
    return this.http.delete(`http://localhost:8585/services/courses/${id}`)

  }

  fetchData(id) {
    //console.log("Exexute excute Hello World Service");
    return this.http.get<Course>(`http://localhost:8585/services/courses/${id}`)

  }

  updateData(course) {
    
    return this.http.put('http://localhost:8585/services/courses', course)
  }

  createData(course){
    console.log(course);
    return this.http.post('http://localhost:8585/services/courses', course)
  }
}
