import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { BookService } from '../book/book.service';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-save-book',
  templateUrl: './save-book.component.html',
  styleUrls: ['./save-book.component.css']
})
export class SaveBookComponent {
  book: Book = {
    name: '',
    price: '',
    author: '',
  };
  submitted = false;

  constructor(private service: BookService) { }

  saveBook(): void {
    if (this.book.name != '' && this.book.price != ''&& this.book.author != '') {
      const data = {
        name: this.book.name,
        price: this.book.price,
        author: this.book.author,
      };

      this.service.saveBook(data)
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
