package com.abc.bookstore.mapper;

import com.abc.bookstore.models.Book;
import com.abc.bookstore.models.Price;
import com.abc.bookstore.models.Publisher;
import com.abc.bookstore.models.ReadingStats;
import com.abc.bookstore.response.BookDto;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RetrieveBookMapperImproved {

    public static BookDto toDto(Book book) {
        var bookDto = new BookDto();

        bookDto.setIsbn(book.getIsbn());
        bookDto.setLanguage(book.getLanguage());
        bookDto.setPages(book.getPages());
        bookDto.setGenre(book.getGenre());

        bookDto.setPublisherAddress(formatPublisherAddress(book.getPublisher()));
        populateReadingStats(book, bookDto);
        populateAuthors(book, bookDto);
        populateTotalBookPrice(book, bookDto);
        return bookDto;
    }

    private static void populateAuthors(Book book, BookDto bookDto) {
        if (book != null && book.getAuthors() != null) {
            List<String> authors = book.getAuthors()
                    .stream()
                    .map(y -> String.join(y.getFirstName(), y.getLastName(), " "))
                    .collect(Collectors.toList());
            bookDto.setAuthorNames(authors);
        }
    }


    private static void populateTotalBookPrice(Book book, BookDto bookDto) {
        Objects.requireNonNull(book);
        if (!CollectionUtils.isEmpty(book.getPrices())) {
            double sum = book
                    .getPrices()
                    .stream()
                    .mapToDouble(Price::getActualPrice)
                    .sum();
            bookDto.setPrice(Double.toString(sum));
        } else {
            bookDto.setPrice("Price not Available");
        }
    }

    private static void populateReadingStats(Book book, BookDto bookDto) {
        if (book != null && book.getReadingStats() != null) {
            ReadingStats readingStats = book.getReadingStats();
            Integer readingPercentage = readingStats.getReadingPercentage();
            Integer timeRemainingToFinish = readingStats.getTimeRemainingToFinish();
            bookDto.setReadingPercentage(Objects.requireNonNullElse(readingPercentage, -1));
            bookDto.setTimeRemainingToFinish(Objects.requireNonNullElse(timeRemainingToFinish, -1));
        }
    }

    static String formatPublisherAddress(Publisher publisher) {
        return Optional.ofNullable(publisher) //
                .map(Publisher::getAddress) //
                .map(address -> Stream.of(
                                address.getLine1(), //
                                address.getLine2(), //
                                address.getCity(), //
                                Optional.ofNullable(address.getPinCode())//
                                        .map(Object::toString) //
                                        .orElse(null)) //
                        .filter(x -> x != null && !x.isEmpty()) //
                        .collect(Collectors.joining(","))) //
                .orElse("No Publisher Address"); //
    }
}
