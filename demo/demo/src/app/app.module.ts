import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{ BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { LibraryComponent } from './library/library.component';
import { HttpClientModule } from '@angular/common/http';
import { BookComponent } from './book/book.component';
import { StudentComponent } from './student/student.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { IssueComponent } from './issue/issue.component';
import { NavbarComponent } from './tools/navbar/navbar.component';
import { PracticeComponent } from './practice/practice.component';
import { SaveBookComponent } from './save-book/save-book.component';
import { FormsModule } from '@angular/forms';
import { IssueBookComponent } from './issue-book/issue-book.component';
import { RegisterStudentComponent } from './register-student/register-student.component';
import { RegisterLibrarianComponent } from './register-librarian/register-librarian.component';
import { timeout } from 'rxjs';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LibraryComponent,
    BookComponent,
    StudentComponent,
    StudentDetailsComponent,
    IssueComponent,
    NavbarComponent,
    PracticeComponent,
    SaveBookComponent,
    IssueBookComponent,
    RegisterStudentComponent,
    RegisterLibrarianComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      progressBar: true,
      timeOut: 1500,
      progressAnimation: 'increasing',
      preventDuplicates: true
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
function ToastrModuleforRoot(): any[] | import("@angular/core").Type<any> | import("@angular/core").ModuleWithProviders<{}> {
  throw new Error('Function not implemented.');
}

