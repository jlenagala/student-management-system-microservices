import { Component, OnInit } from '@angular/core';
import { Student } from '../../model/student';
import { StudentService } from '../../service/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Student[];
  message: string
  constructor(
    private studentService: StudentService,
    private router: Router
  ) {

  }

  ngOnInit(): void {
    this.loadStudent();

  }

  loadStudent() {
    this.studentService.fetchAllData().subscribe(
      response => {
        console.log(response);
        this.students = response;
      }
    );
  }

  deleteStudent(id) {
    // console.log(`Deleted ${id}`)
    this.studentService.deleteData(id).subscribe(
      response => {
        console.log(response);
        this.message = (`Deleted student ${id}`);
        this.loadStudent();
      }

    );
  }

  updateStudent(id) {
    console.log(`Updated ${id}`);
    this.router.navigate(['students', id])

  }
  addStudent() {
    this.router.navigate(['students', -1])
  }

  regCourse(id){
    console.log(`Updated ${id}`);
    this.router.navigate(['allocations',-1, id])


  }
}