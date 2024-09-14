import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LibraryComponent } from './library/library.component';
import { BookComponent } from './book/book.component';
import { StudentComponent } from './student/student.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { IssueComponent } from './issue/issue.component';
import { PracticeComponent } from './practice/practice.component';
import { SaveBookComponent } from './save-book/save-book.component';
import { RegisterStudentComponent } from './register-student/register-student.component';
import { IssueBookComponent } from './issue-book/issue-book.component';
import { RegisterLibrarianComponent } from './register-librarian/register-librarian.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: "library", component: LibraryComponent },
  { path: "book", component: BookComponent },
  { path: "student", component: StudentComponent },
  { path: "issue", component: IssueComponent},
  { path: "student/:studId", component: StudentDetailsComponent},
  {path: "practice", component: PracticeComponent},
  {path: "save-book", component: SaveBookComponent, pathMatch: 'full'},
  {path: "register-student", component: RegisterStudentComponent, pathMatch: 'full'},
  {path: "issue-book", component: IssueBookComponent, pathMatch: 'full'},
  {path: "register-librarian", component: RegisterLibrarianComponent, pathMatch: 'full'},
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
