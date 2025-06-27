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
}
