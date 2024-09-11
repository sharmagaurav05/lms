package com.lms.lms.controller;

import com.lms.lms.model.Librarian;
import com.lms.lms.service.LibrarianService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/librarian")
public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;

    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @GetMapping("/get-all-librarian")
    public ResponseEntity<List<Librarian>> getAllLibrarian() {
        List<Librarian> librarians = librarianService.getAllLibrarian();
        return ResponseEntity.ok(librarians);
    }

    @GetMapping("/get-librarian/{librarianId}")
    public ResponseEntity<Librarian> getLibrarianById(@PathVariable String librarianId) {
        Librarian librarians = librarianService.getLibrarianById(librarianId);
        return ResponseEntity.ok(librarians);
    }

    @PostMapping("/save-librarian")
    public ResponseEntity<Librarian> saveNewLibrarian(@RequestBody Librarian librarian) {
        librarianService.saveNewLibrarian(librarian);
        return ResponseEntity.ok(librarian);
    }

    @PostMapping("/save-librarians")
    public ResponseEntity<String> saveLibrarians(@RequestBody List<Librarian> librarianList) {
        librarianService.saveLibrarians(librarianList);
        return ResponseEntity.ok("The list of librarians has been successfully saved :");
    }

    @DeleteMapping("/delete-librarian/{librarianId}")
    public ResponseEntity deleteLibrarianById(@PathVariable String librarianId) {
        librarianService.deleteLibrarianById(librarianId);
        return ResponseEntity.ok("Librarian with " + librarianId + "has been deleted successfully : ");
    }

    @PutMapping("/save-librarian")
    public ResponseEntity saveUpdatedLibrarian(@RequestBody Librarian librarian){
        librarianService.saveUpdatedLibrarian(librarian);
        return ResponseEntity.ok("Librarian saved successfully : ");
    }

    @DeleteMapping("/delete-all-librarians")
    public ResponseEntity deleteAllLibrarians(){
        librarianService.deleteAllLibrarians();
        return ResponseEntity.ok("Librarians deleted successfully");
    }
}