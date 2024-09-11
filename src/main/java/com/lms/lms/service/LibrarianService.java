package com.lms.lms.service;

import com.lms.lms.model.Librarian;
import com.lms.lms.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;

    public LibrarianService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }
    public List<Librarian> getAllLibrarian() {
        return librarianRepository.getAllLibrarian();
    }

    public Librarian getLibrarianById(String librarianId) {
        return librarianRepository.getLibrarianById(librarianId);
    }

    public Librarian saveNewLibrarian(Librarian librarian){
        librarianRepository.saveNewLibrarian(librarian);
        return librarian;
    }

    public void saveLibrarians(List<Librarian> librariansList){
        librarianRepository.saveLibrarians(librariansList);
    }
    public void deleteLibrarianById(String librarianId){
        librarianRepository.deleteLibrarianById(librarianId);
    }

    public void saveUpdatedLibrarian(Librarian librarian) {
        librarianRepository.saveUpdatedLibrarian(librarian);
    }

    public void deleteAllLibrarians() {
        librarianRepository.deleteAllLibrarians();
    }
}
