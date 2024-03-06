package com.abc.bookstore.models;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Book {
    private String isbn;
    private String  name;
    private Integer pages;
    private String language;
    private String genre;
    private List<Author> authors;
    private Publisher publisher;

    private List<Price> prices;

    private ReadingStats readingStats;
    public ReadingStats getReadingStats() {
        return this.readingStats;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setReadingStats(ReadingStats readingStats) {
        this.readingStats = readingStats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
