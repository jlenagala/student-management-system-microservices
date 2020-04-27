import { Component, OnInit } from '@angular/core';
import { Allocation } from '../../model/allocation';
import { AllocationService } from '../../services/allocation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from 'src/app/course/models/course';
import { CourseService } from 'src/app/course/services/course.service';
import { CourseAlo } from '../../model/courseAlo';
import { TokenStorageService } from 'src/app/auth/services/token-storage.service';

@Component({
  selector: 'app-allocation-details',
  templateUrl: './allocation-details.component.html',
  styleUrls: ['./allocation-details.component.css']
})
export class AllocationDetailsComponent implements OnInit {
  id: number;
  stuId:number;
  empId:number;
  allocation: Allocation;
  courses:CourseAlo[];
  currentUser: any;
  constructor(
    private token: TokenStorageService,
    private courseService: CourseService,
    private allocationService: AllocationService,
    private route: ActivatedRoute,
    private router: Router

  ) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id1'];
    this.stuId = this.route.snapshot.params['id2'];
    this.currentUser = this.token.getUser();
    
    this.allocation =  {
      "allocationId":1,
      "studentId":1,
      "courseId": 1,
      "employeeId": 1,
      "fromDate": new Date(),
      "toDate": new Date()
    }
    this.courses = [{
      id: 1,
      name: 'Web',
      duration: 6,
      description: '',
      regDate: new Date(),
      currentStatus: '',
      courseType: ''
    }];

  
    this.courseService.fetchAllData().subscribe(
      response => {
        console.log(response);
        this.courses = response;
      }
    );
    // }
    // if (this.id != -1) {
    //   this.allocationService.fetchData(this.id).subscribe(
    //     data => this.allocation = data
    //   );
    // }

  }

  saveAllocations() {
    //console.log('"before"');
    console.log(this.id);
    console.log(this.stuId);
    this.allocation.allocationId=this.allocation.allocationId+1;
    this.allocation.studentId=this.stuId;
    this.allocation.employeeId=this.currentUser.id;
    if (this.id == -1) {
      //console.log('"Afterfore"');
      this.allocationService.createData(this.allocation).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['students']);

        }
      );
    } else {
      console.log('"else"');
      console.log(this.id);
      this.allocationService.updateData(this.allocation).subscribe(
        data => {

          console.log(data);
          this.router.navigate(['students']);
        }
      );
    }

  }
}

