import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { StudentService } from './student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  students: any;
  studentData: any;

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.getAllStudents();
  }

  getAllStudents(){
    this.studentService.getAllStudents().subscribe((data: any)=>{
      this.students = data;
    })
  }

  deleteStudentById(studId: string){
    this.studentService.deleteStudentById(studId).subscribe((data: any)=>{
      console.log("Student deleted successfully : ");
    })
  }

  getStudentData(studId: string){
    this.studentService.getStudentById(studId).subscribe((data: any) => {
      this.studentData = data;
    })
  }
}

