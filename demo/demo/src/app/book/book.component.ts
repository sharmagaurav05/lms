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
  booksDuplicate: any;

  constructor(private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
    this.getAllBooks();

  }

  getAllBooks() {
    this.bookService.getAllBooks().subscribe((data: any) => {
      this.books = data;
     this.booksDuplicate = data;
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

  getBooksByPriceRange(event: Event){
    const endPrice = (event.target as HTMLInputElement).value;
    this.bookService.getBooksByPriceRange(endPrice).subscribe((data: any) =>{
      this.books = data;
    })
  }

  getBooksByAuthor(event: Event){
    const authorName = (event.target as HTMLInputElement).value;
    this.bookService.getBooksByAuthor(authorName).subscribe((data: any) =>{
      this.books = data;
    })
  }
}
