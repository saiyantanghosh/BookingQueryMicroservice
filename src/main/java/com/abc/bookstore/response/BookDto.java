package com.abc.bookstore.response;

import java.util.ArrayList;
import java.util.List;

public class BookDto {
    private String isbn;
    private Integer pages;
    private String language;
    private List<String> authorNames;
    private String genre;

    private String publisherName;

    private String publisherAddress;

    private Integer readingPercentage;

    private Integer timeRemainingToFinish;

    private String price;

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

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public Integer getReadingPercentage() {
        return readingPercentage;
    }

    public void setReadingPercentage(Integer readingPercentage) {
        this.readingPercentage = readingPercentage;
    }

    public Integer getTimeRemainingToFinish() {
        return timeRemainingToFinish;
    }

    public void setTimeRemainingToFinish(Integer timeRemainingToFinish) {
        this.timeRemainingToFinish = timeRemainingToFinish;
    }

    public List<String> getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(List<String> authorNames) {
        this.authorNames = authorNames;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
