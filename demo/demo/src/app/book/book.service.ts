import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<any>{
    return this.http.get('http://localhost:8080/book/get-all-books');
  }

  getBookById(bookId: string): Observable<any> {
    return this.http.get(`http://localhost:8080/book/get-book/${bookId}`);
  }

  deleteBookById(bookId: string): Observable<any>{
    return this.http.get(`http://localhost:8080/book/delete-book/${bookId}`);
  }

  getBooksByPriceRange(endPrice: string){
    if (endPrice === '0') {
      return this.http.get('http://localhost:8080/book/get-all-books');
    } else {
      return this.http.get(`http://localhost:8080/book/filter-by-price-range/startPrice/${0}/endPrice/${endPrice}`);
    }
  }


  getBooksByAuthor(authorName: string) {
    if (authorName === 'All') {
      return this.http.get('http://localhost:8080/book/get-all-books');
    }
    else {
      return this.http.get(`http://localhost:8080/book/author/books/${authorName}`);
    }
  }

  saveBook(data: any): Observable<any>{
    return this.http.post("http://localhost:8080/book/save-book",data);
  }
}
