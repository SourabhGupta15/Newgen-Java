import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee-service';

@Component({
  selector: 'app-employee-details',
  imports: [],
  templateUrl: './employee-details.html',
  styleUrl: './employee-details.css'
})
export class EmployeeDetails {
  id!: number;
  employee: Employee = new Employee;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit() {
    this.id = parseInt(window.location.pathname.split('/').pop() || '0');
    this.employeeService.getEmployeeByID(this.id).subscribe((data: Employee) => {
      console.log('get employee by id response :', data);
      this.employee = data;
    }, error => console.log('error while calling get employee by id api :', error));
  }
}
