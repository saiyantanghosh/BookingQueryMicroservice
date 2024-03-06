package com.abc.bookstore.response;

import java.util.List;

public class RetrieveBooksResponse {

    private List<BookDto> books;

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
