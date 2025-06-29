import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { CommonModule } from '@angular/common';
import { EmployeeService } from '../service/employee-service';

@Component({
  selector: 'app-employee-list',
  imports: [CommonModule],
  templateUrl: './employee-list.html',
  styleUrl: './employee-list.css'
})
export class EmployeeList implements OnInit{

  constructor(private employeeService: EmployeeService) {}
  employeeList: Employee[] = [];   //declared employees as an array of Employee type

  ngOnInit() {
      // this.employeeList = [      //dummy data
      //   { id: 1, name: 'John', salary: 10000, department: 'IT'},
      //   { id: 2, name: 'Smith', salary: 15000, department: 'HR'},
      //   { id: 3, name: 'Mark', salary: 20000, department: 'IT'},
      //   { id: 4, name: 'Mary', salary: 25000, department: 'HR'},
      //   { id: 5, name: 'Sam', salary: 30000, department: 'IT'}
      // ]

    this.getEmployees();
  }
  
  getEmployees() {
    this.employeeService.getEmployees().subscribe(data => {
      data.forEach((employee) => console.log(employee));
      this.employeeList = data;
    })
  }
  
  updateEmployee(id: number | null) {
    console.log('inside updateEmployee method :', id);
    window.location.href = `/update-employee/${id}`;
  }

  deleteEmployee(id: number | null) {
    console.log('inside deleteEmployee method :', id);
    this.employeeService.deleteEmployee(id).subscribe((data: any) => {
      console.log('delete api response :', data);
      this.getEmployees();
    }, error => console.log('error from delete api call :', error));
  }

  viewEmployee(id: number | null) {
    console.log('inside viewEmployee method :', id);
    window.location.href = `/employee-details/${id}`;
  }
}
