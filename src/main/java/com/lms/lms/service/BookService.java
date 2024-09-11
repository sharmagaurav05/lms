package com.lms.lms.service;

import com.lms.lms.dto.BookDTO;
import com.lms.lms.model.Book;
import com.lms.lms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    public Book getBookById(String bookId){
        return bookRepository.getBookById(bookId);
    }



    public void saveBooks(List<BookDTO> books){
        books.forEach(bookDTO -> {
            saveBook(bookDTO);
        });
    }

    public void deleteBookById(String bookId){
        bookRepository.deleteBookById(bookId);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.getBooksByAuthor(author);
    }

    public List<Book> getBooksByPriceRange(String startPrice, String endPrice){
        List<Book> books = bookRepository.getAllBooks();
        List<Book> booksInRange = new ArrayList<>();
        books.forEach(book -> {
            if(Integer.parseInt(book.getPrice()) >= Integer.parseInt(startPrice ) &&
                    Integer.parseInt(book.getPrice()) <= Integer.parseInt(endPrice)){
                booksInRange.add(book);
            }
        });
        return booksInRange;
    }

    public void deleteAllBooks() {
        bookRepository.deleteAllBooks();
    }

    public Book saveBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setPrice(bookDTO.getPrice());
        book.setAuthor(bookDTO.getAuthor());
        bookRepository.saveBook(book);
        return book;
    }
}
