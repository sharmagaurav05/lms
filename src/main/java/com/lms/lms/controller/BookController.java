package com.lms.lms.controller;

import com.lms.lms.dto.BookDTO;
import com.lms.lms.model.Book;
import com.lms.lms.service.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/get-book/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable String bookId) {
        Book book = bookService.getBookById(bookId);
        return ResponseEntity.ok(book);
    }

    @PostMapping(value = "/save-book", consumes= {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Book> saveBook(@RequestBody BookDTO bookDTO) {
        Book book = bookService.saveBook(bookDTO);
        return ResponseEntity.ok(book);
    }

    @PostMapping(value = "/save-books", consumes= {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> saveBooks(@RequestBody List<BookDTO> books) {
        bookService.saveBooks(books);
        return ResponseEntity.ok("Book saved successfully : ");
    }

    @GetMapping("/delete-book/{bookId}")
    public ResponseEntity deleteBookById(@PathVariable String bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.ok("Book deleted successfully : ");
    }

    @GetMapping("/filter-by-price-range")
    public ResponseEntity<List<Book>> getBooksByPriceRange(@RequestParam String startPrice, @RequestParam String endPrice){
        List<Book> books = bookService.getBooksByPriceRange(startPrice,endPrice);
        return ResponseEntity.ok(books);
    }


    @GetMapping("/author/books")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author){
        List<Book> books = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return ResponseEntity.ok("All books deleted successfully: ");
    }
}


