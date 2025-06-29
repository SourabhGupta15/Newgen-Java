import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private BASE_URL = 'http://localhost:8090/api/employees';
  constructor(private httpClient: HttpClient) { }

  getEmployees(): Observable<Employee[]> {
    console.log('Inside getEmployees()');
    return this.httpClient.get<Employee[]>(this.BASE_URL);
  }

  createEmployee(employee: Employee): Observable<Object> {
    return this.httpClient.post(this.BASE_URL, employee);
  }

  getEmployeeByID(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${this.BASE_URL}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object> {
    return this.httpClient.put(`${this.BASE_URL}/${id}`, employee);
  }

  deleteEmployee(id: number | null): Observable<Object> {
    return this.httpClient.delete(`${this.BASE_URL}/${id}`);
  }
}
