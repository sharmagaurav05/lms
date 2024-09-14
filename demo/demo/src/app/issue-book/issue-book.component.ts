import { Component, OnInit } from '@angular/core';
import { Issue } from '../models/issue';
import { IssueService } from '../issue/issue.service';
import { BookService } from '../book/book.service';
import { StudentService } from '../student/student.service';
import { LibraryService } from '../service/library.service';

@Component({
  selector: 'app-issue-book',
  templateUrl: './issue-book.component.html',
  styleUrls: ['./issue-book.component.css']
})
export class IssueBookComponent implements OnInit {
  issue: Issue = {
    bookId: '',
    studentId: '',
    issuerId: '',
  };

  submitted = false;

  books: any;
  students: any;
  issuers: any;

  constructor(private service: IssueService, private bookService: BookService, private studentService: StudentService, private libraryService: LibraryService) { }

  ngOnInit(): void {
    this.getAllBooks();
    this.getAllIssuers();
    this.getAllStudents();
  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe((data: any) => {
      this.books = data;
    })
  }

  getAllStudents() {
    this.studentService.getAllStudents().subscribe((data: any) => {
      this.students = data;
    })
  }

  getAllIssuers() {
    this.libraryService.getAllLibrarians().subscribe((data: any) => {
      this.issuers = data;
    })
  }




  issueBook(): void {
    if (this.issue.bookId != '' && this.issue.studentId != '' && this.issue.issuerId != '') {
      const data = {
        bookId: this.issue.bookId,
        studentId: this.issue.studentId,
        issuerId: this.issue.issuerId
      };

      this.service.issueBook(data)
        .subscribe({
          next: (response: any) => {
            console.log(response);
            this.submitted = true;
          },
          error: (e: any) => console.error(e)
        });
    }
  }
}
