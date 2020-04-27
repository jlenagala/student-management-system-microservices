import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Allocation } from '../model/allocation';
import { AllocationResponse } from '../model/allocation-response';

@Injectable({
  providedIn: 'root'
})
export class AllocationService {
  constructor(
    private http: HttpClient
  ) { }
  
  fetchAllDataById(id) {
    //console.log("Exexute excute Hello World Service");
    return this.http.get<AllocationResponse>(`http://localhost:8686/services/allocations/${id}?type=full`)

  }

  fetchAllData() {
    //console.log("Exexute excute Hello World Service");
    return this.http.get<Allocation[]>('http://localhost:8686/services/allocations')

  }

  deleteData(id) {
    return this.http.delete(`http://localhost:8686/services/allocations/${id}`)

  }

  fetchData(id) {
    //console.log("Exexute excute Hello World Service");
    return this.http.get<Allocation>(`http://localhost:8686/services/allocations/${id}`)

  }

  updateData(allocations) {
    
    return this.http.put('http://localhost:8686/services/allocations', allocations)
  }

  createData(allocations){
    //console.log(allocations);
    return this.http.post('http://localhost:8686/services/allocations', allocations)
  }
}