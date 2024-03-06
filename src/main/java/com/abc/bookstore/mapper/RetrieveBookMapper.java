package com.abc.bookstore.mapper;

import com.abc.bookstore.models.Book;
import com.abc.bookstore.models.Price;
import com.abc.bookstore.models.Publisher;
import com.abc.bookstore.response.BookDto;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveBookMapper {

    public static BookDto toDto(Book book){
            var bookDto = new BookDto();
            bookDto.setIsbn(book.getIsbn());
            bookDto.setLanguage(book.getLanguage());
            bookDto.setPages(book.getPages());
            bookDto.setPublisherAddress(formatPublisherAddress(book.getPublisher()));
            bookDto.setGenre(book.getGenre());
            populateTotalBookPrice(book, bookDto);

            if(book.getReadingStats()!=null){
                bookDto.setReadingPercentage(book.getReadingStats().getReadingPercentage());
            }


            if(book.getAuthors()!=null && !book.getAuthors().isEmpty()) {
               List<String> authorsName = book.getAuthors().stream().map(x -> (String.join(x.getFirstName(), x.getLastName(), " "))).collect(Collectors.toList());
                bookDto.setAuthorNames(authorsName);
            }

        return bookDto;
    }


private static void populateTotalBookPrice(Book book, BookDto bookDto) {
        if(book!=null && book.getPrices()!=null && book.getPrices().isEmpty()){
            double sum = book
                    .getPrices()
                    .stream()
                    .mapToDouble(Price::getActualPrice)
                    .sum();
            bookDto.setPrice(Double.toString(sum));
        }else{
            bookDto.setPrice("Price not Available");
        }
    }

    private static String formatPublisherAddress(Publisher publisher) {
        //nested null check
        if(publisher!=null){
            var address = publisher.getAddress();
            if (address != null) {
                String formatterAddress =  address.getLine1() +
                        "," +
                        address.getLine2() +
                        "," +
                        address.getCity() ;
                if(address.getPinCode()!=null){
                    formatterAddress = formatterAddress
                            +"," +address.getPinCode().toString();
                }
                return formatterAddress;
            }
        }
        return null;
    }

    // buggy code
    /*private static String formatPublisherAddress(Publisher publisher) {
        var address = publisher.getAddress();
         return address.getLine1() +
                 "," +
                 address.getLine2() +
                 "," +
                 address.getCity() +
                 "," +
                 address.getPinCode().toString();
    }*/
}