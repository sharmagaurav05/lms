package com.lms.lms.repository;

import com.lms.lms.dto.BookDTO;
import com.lms.lms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public BookRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<Book> getAllBooks(){
        return mongoTemplate.findAll(Book.class);
    }

    public Book getBookById(String bookId){
        return mongoTemplate.findById(bookId, Book.class);
    }

    public void saveBook(Book book){
        mongoTemplate.save(book,"Book");
    }

    public void saveBooks(List<BookDTO> books){
        books.forEach(book -> {
            mongoTemplate.save(book,"Book");
        });
    }

    public void deleteBookById(String bookId){
        Query query = new Query();
        query.addCriteria(Criteria.where("bookId").is(bookId));
        mongoTemplate.findAndRemove(query,Book.class);
    }

    public List<Book> getBooksByAuthor(String author) {
        Query query = new Query();
        query.addCriteria(Criteria.where("author").is(author));
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }

    public void deleteAllBooks() {
//        Query query =  new Query();
        mongoTemplate.remove(new Query(),"Book");
    }
}

