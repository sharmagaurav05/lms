import { Component, Input, OnInit } from '@angular/core';
import { StudentService } from '../student/student.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  student: any
  @Input() data:any

  constructor(private studentService: StudentService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let studId = this.activatedRoute.snapshot.paramMap.get('studId');
    this.getStudentById(studId !=null? studId: "");
  }

  getStudentById(studId: string){
    this.studentService.getStudentById(studId).subscribe((data: any)=>{
      this.student = data;
    })
  }
}
