import { Component, OnInit } from '@angular/core';
import { Student } from '../../model/student';
import { StudentService } from '../../service/student.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  id: number;

  student: Student;
  constructor(
    private studentService: StudentService,
    private route: ActivatedRoute,
    private router: Router

  ) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    this.student = {
      "id": this.id,
      "nic": '',
      "firstName": '',
      "lastName": '',
      "dob": new Date(),
      "regDate": new Date(),
      "gender": '',
      "currentStatus": '',
      "telephones":'',
      // "telephones": [{
      //   "number": ''
      // }],
      "addresses": {
        "lane1": '',
        "lane2": '',
        "city": ''
      }
    }

    if (this.id != -1) {
      this.studentService.fetchData(this.id).subscribe(
        data => this.student = data
      );
    }

  }

  saveStudents() {
    //console.log('"before"');
    if (this.id == -1) {
      //console.log('"Afterfore"');
      this.studentService.createData(this.student).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['students']);

        }
      );
    } else {
      console.log('"else"');
      console.log(this.id);
      this.studentService.updateData(this.student).subscribe(
        data => {

          console.log(data);
          this.router.navigate(['students']);
        }
      );
    }

  }
}

