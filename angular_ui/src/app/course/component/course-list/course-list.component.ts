import { Component, OnInit } from '@angular/core';
import { Course } from '../../models/course';
import { CourseService } from '../../services/course.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  courses: Course[];
  message: string
  constructor(
    private courseService: CourseService,
    private router: Router
  ) {

  }

  ngOnInit(): void {
    this.loadCourses();

  }

  loadCourses() {
    this.courseService.fetchAllData().subscribe(
      response => {
        console.log(response);
        this.courses = response;
      }
    );
  }

  deleteCourses(id) {
    // console.log(`Deleted ${id}`)
    this.courseService.deleteData(id).subscribe(
      response => {
        console.log(response);
        this.message = (`Deleted Courses ${id}`);
        this.loadCourses();
      }

    );
  }

  updateCourses(id) {
    console.log(`Updated ${id}`);
    this.router.navigate(['courses', id])

  }
  addCourses() {
    this.router.navigate(['courses', -1])
  }
}
