import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Career } from './career/career';
import { Aboutus } from './aboutus/aboutus';
import { Course } from './course/course';
import { Contactus } from './contactus/contactus';
import { Counter } from './counter/counter';
import { EmployeeList } from './employee-list/employee-list';
import { CreateEmployee } from './create-employee/create-employee';
import { UpdateEmployee } from './update-employee/update-employee';
import { EmployeeDetails } from './employee-details/employee-details';

export const routes: Routes = [
    { path: '', pathMatch: 'full', component: Home},
    { path: 'career', component: Career},
    { path: 'about', component: Aboutus},
    { path: 'course', component: Course},
    { path: 'contact', component: Contactus},
    { path: 'counter', component: Counter},
    { path: 'employee-list', component: EmployeeList},
    { path: 'create-employee', component: CreateEmployee},
    { path: 'update-employee/:id', component: UpdateEmployee},
    { path: 'employee-details/:id', component: EmployeeDetails}
];
