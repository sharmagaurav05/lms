import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  getAllStudents(): Observable<any>{
    return this.http.get(`http://localhost:8080/student/get-all-students`);
  }

  getStudentById(studId: string): Observable<any>{
    return this.http.get(`http://localhost:8080/student/get-student/${studId}`);
  }

  deleteStudentById(studId: string): Observable<any>{
    return this.http.get(`http://localhost:8080/student/delete-student/${studId}`);
  }

  registerStudent(data: any): Observable<any>{
    return this.http.post("http://localhost:8080/student/save-student",data);
  }
}


