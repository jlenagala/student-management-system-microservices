import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Allocation } from '../../model/allocation';
import { AllocationResponse } from '../../model/allocation-response';
import { AllocationService } from '../../services/allocation.service';
import { Student } from 'src/app/student/model/student';
import { StudentService } from 'src/app/student/service/student.service';

@Component({
  selector: 'app-allocation-list',
  templateUrl: './allocation-list.component.html',
  styleUrls: ['./allocation-list.component.css']
})
export class AllocationListComponent implements OnInit {
 student:Student[]
  allocation: Allocation[];
  allocationResponse: AllocationResponse[];
  message: string
  constructor(
    private studentService: StudentService,
    private allocationService: AllocationService,
    private router: Router
  ) {

  }

  ngOnInit(): void {
    // this.student = [{
    //   id: 1,
    //   nic: '',
    //   firstName: '',
    //   lastName: '',
    //   dob: new Date(),
    //   regDate: new Date(),
    //   gender: '',
    //   currentStatus: '',
    //   telephones:'',
    //   // "telephones": [{
    //   //   "number": ''
    //   // }],
    //   addresses: {
    //     lane1: '',
    //     lane2: '',
    //     city: ''
    //   }
    // }]
    
    this.allocationService.fetchAllData().subscribe(
      response => {
        console.log(response);
        this.allocation = response; 
      }
    );
    
  }

 

  deleteAllocation(id) {
    // console.log(`Deleted ${id}`)
    this.allocationService.deleteData(id).subscribe(
      response => {
        console.log(response);
        this.message = (`Deleted allocations ${id}`);
       // this.loadAllocation();
      }

    );
  }

  updateAllocation(id) {
    console.log(`Updated ${id}`);
    this.router.navigate(['allocations', id])

  }
  addAllocation() {
    this.router.navigate(['allocations', -1])
  }
}