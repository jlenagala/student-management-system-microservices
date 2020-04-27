import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../../models/course';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {
  id: number;

  course: Course;
  constructor(
    private courseService: CourseService,
    private route: ActivatedRoute,
    private router: Router

  ) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    this.course = {
      "id": this.id,
      "name": '',
      "duration": 0,
      "description": '',
      "regDate": new Date(),
      "currentStatus": '',
      "courseType": ''
    };

    if (this.id != -1) {
      this.courseService.fetchData(this.id).subscribe(
        data => this.course = data
      );
    }

  }

  saveCourses() {
    //console.log('"before"');
    if (this.id == -1) {
      //console.log('"Afterfore"');
      this.courseService.createData(this.course).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['courses']);

        }
      );
    } else {
      console.log('"else"');
      console.log(this.id);
      this.courseService.updateData(this.course).subscribe(
        data => {

          console.log(data);
          this.router.navigate(['courses']);
        }
      );
    }

  }
}

