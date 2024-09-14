import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {
  
  constructor(private http: HttpClient) { }

  getAllLibrarians(): Observable<any> {
    return this.http.get('http://localhost:8080/librarian/get-all-librarian');
  }
  
  getLibrarianById(librarianId: string): Observable<any> {
    return this.http.get(`http://localhost:8080/librarian/get-librarian/${librarianId}`);
  }
  
  deleteLibrarianById(librarianId: string): Observable<any> {
    return this.http.delete(`http://localhost:8080/librarian/delete-librarian/${librarianId}`);
  }

  registerLibrarian(data: any): Observable<any>{
    return this.http.post("http://localhost:8080/librarian/save-librarian",data);
  }
}
