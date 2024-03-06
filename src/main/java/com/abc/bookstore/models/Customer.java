package com.abc.bookstore.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document("customer")
public class Customer {
    private String customerId;
    private String name;

   private List<Book> readingBooks;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getReadingBooks() {
        return readingBooks;
    }

    public void setReadingBooks(List<Book> readingBooks) {
        this.readingBooks = readingBooks;
    }
}
