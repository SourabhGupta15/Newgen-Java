import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../service/employee-service';

@Component({
  selector: 'app-update-employee',
  imports: [FormsModule],
  templateUrl: './update-employee.html',
  styleUrl: './update-employee.css'
})
export class UpdateEmployee {
  id!: number;      //the `!` tells javascript to not throw compile time error, we will assign this value
  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService) {}

  ngOnInit() {
    this.id = parseInt(window.location.pathname.split('/').pop() || '0');
    this.employeeService.getEmployeeByID(this.id).subscribe((data: Employee) => {
      console.log('get employee by id response :', data);
      this.employee = data;
    }, error => console.log('error while calling get employee by id api :', error));
  }

  onSubmit() {
    console.log('inside onSubmit in update-employee component');
    this.employeeService.updateEmployee(this.id, this.employee).subscribe((data: Object) => {
      console.log('response from put api :', data);
    }, error => console.log('error from put api :', error));
    window.location.href = '/employee-list';
  }
}
