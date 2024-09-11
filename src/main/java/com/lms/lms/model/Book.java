package com.lms.lms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Book")
public class Book {

    @Id
    private String bookId;
    private String name;
    private String price;
    private String author;

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public String getBookId(){
        return bookId;
    }
    public void setBookId(String bookId){
        this.bookId=bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }
}