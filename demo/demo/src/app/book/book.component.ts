import { Component, OnInit } from '@angular/core';
import { BookService } from './book.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books: any;
  bookData: any;

  constructor(private bookService: BookService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getAllBooks();
  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe((data: any) => {
      this.books = data;
    })
  }

  deleteBook(bookId: string) {
    this.bookService.deleteBookById(bookId).subscribe((data: any) => {
      console.log("Book deleted successfully:")
    })
  }

  addBookData(bookId: string){
    this.bookService.getBookById(bookId).subscribe((data: any) =>{
      this.bookData = data;
    })
  }
  showData(){

  }
}
