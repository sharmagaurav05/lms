import { Component, OnInit } from '@angular/core';
import { Student } from '../models/student';
import { StudentService } from '../student/student.service';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.css']
})
export class RegisterStudentComponent {
  student: Student = {
    studName: '',
    studEmail: '',
    studAddress: '',
    studPhoneNo: '',
  };
  submitted = false;

  constructor(private service: StudentService) { }


  registerStudent(): void {
    if (this.student.studName != '' && this.student.studEmail != '' && this.student.studAddress != '' && this.student.studPhoneNo != '') {
      const data = {
        studName: this.student.studName,
        studEmail: this.student.studEmail,
        studAddress: this.student.studAddress,
        studPhoneNo: this.student.studPhoneNo,
      };

      this.service.registerStudent(data)
        .subscribe({
          next: (response) => {
            console.log(response);
            this.submitted = true;
          },
          error: (e) => console.error(e)
        });
    }
  }
}
