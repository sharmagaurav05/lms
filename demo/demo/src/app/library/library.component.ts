import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {
 
  librarians: any;
  librarianData: any;

  constructor(private libraryService: LibraryService, private router: Router) { }

  ngOnInit(): void {
    this.getAllLibrarians();
  }

  getAllLibrarians() {
    this.libraryService.getAllLibrarians().subscribe((data: any) => {
      this.librarians = data;
    })
  }

  deleteLibrarian(librarianId: string) {
    this.libraryService.deleteLibrarianById(librarianId).subscribe((data: any) => {
      console.log("Librarian Deleted Successfully")
    })
    this.router.navigateByUrl("/library")
  }

  addLibrarianData(librarianId: string) {
    this.libraryService.getLibrarianById(librarianId).subscribe((data: any) => {
      this.librarianData = data;
    })
  }

}