import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { Librarian } from '../models/librarian';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-register-librarian',
  templateUrl: './register-librarian.component.html',
  styleUrls: ['./register-librarian.component.css']
})
export class RegisterLibrarianComponent {
  librarian: Librarian = {
    name: '',
    email: '',
    address: '',
    phoneNo: ''
  }

  submitted = false;

  constructor(private service: LibraryService) { }

  registerLibrarian(): void {
    if (this.librarian.name != '' && this.librarian.email != '' && this.librarian.address != '' && this.librarian.phoneNo != '') {
      const data = {
        name: this.librarian.name,
        email: this.librarian.email,
        address: this.librarian.address,
        phoneNo: this.librarian.phoneNo
      };

      this.service.registerLibrarian(data)
        .subscribe({
          next: (response) => {
            console.log(response);
            this.submitted = true;
          },

          error: (e) => console.error(e)
        });
    }
  }

  // newLibrarian(): void {
  //   this.submitted = false;
  //   this.librarian = {
  //     name: '',
  //     email: '',
  //     address: '',
  //     phoneNo: ''
  //   };
  // }
}
