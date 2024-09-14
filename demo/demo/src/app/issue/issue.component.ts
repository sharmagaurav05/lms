import { Component, OnInit } from '@angular/core';
import { IssueService } from './issue.service';
import { StudentService } from '../student/student.service';
import { LibraryService } from '../service/library.service';
import { BookComponent } from '../book/book.component';
import { BookService } from '../book/book.service';
import { tick } from '@angular/core/testing';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {
  issues: any;
  issueData: any;
  studentDetails: any;
  librarianDetails: any;
  bookDetails: any;

  constructor(private issueService: IssueService, private studentService: StudentService, private librarianService: LibraryService, private bookService: BookService) { }

  ngOnInit(): void {
    this.getAllIssues();
  }

  getAllIssues(){
    this.issueService.getAllIssues().subscribe((data: any)=>{
      this.issues = data;
    })
  }
  getDeletedById(issueId: string){
    this.issueService.getDeletedById(issueId).subscribe((data: any)=>{
      console.log("Issue info deleted successfully : ");
    })
  }




  addIssueData(issueId: string){
    this.issueService.getIssueById(issueId).subscribe((data: any)=>{
      this.issueData = data;
      this.studentService.getStudentById(data?.studentId).subscribe((studentData: any) => {
        this.studentDetails = studentData;
      })
      this.librarianService.getLibrarianById(data?.issuerId).subscribe((librarianData: any) => {
        this.librarianDetails = librarianData;
      })
    })
  }

  getBookDetails(bookId: string) {
    console.log("bookId: " + bookId)
    this.bookService.getBookById(bookId).subscribe((bookData: any) => {
      this.bookDetails = bookData;
      console.log(bookData)
    })
  }
}
