import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IssueService {

  constructor(private http: HttpClient) { }

  getAllIssues(): Observable<any>{
    return this.http.get(`http://localhost:8080/issue/get-all-issues`);
  }

  getIssueById(issueId: string): Observable<any> {
    return this.http.get(`http://localhost:8080/issue/get-issued/${issueId}`);
  }

  getDeletedById(issueId: string): Observable<any>{
    return this.http.delete(`http://localhost:8080/issue/delete-issue/${issueId}`);
  }

  issueBook(data: any): Observable<any>{
    return this.http.post("http://localhost:8080/issue/issue-book", data);
  }
}
