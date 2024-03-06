package com.abc.bookstore.mapper;

import com.abc.bookstore.models.*;
import com.abc.bookstore.response.BookDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RetrieveBookMappingImprovedTest {

    @Test
    public void testPositiveWithHistoryStats(){
        Book book = new Book();
        book.setIsbn("97321114144");
        book.setGenre("Technical");
        book.setLanguage("English");
        book.setPages(200);
        ReadingStats readingStats = new ReadingStats();
        readingStats.setReadingPercentage(3);
        book.setReadingStats(readingStats);
        BookDto dto = RetrieveBookMapper.toDto(book);
        assertEquals(3,dto.getReadingPercentage());

    }
    @Test
    public void testNegativeWithHistoryStats(){
        Book book = new Book();
        book.setIsbn("97321114144");
        book.setGenre("Technical");
        book.setLanguage("English");
        book.setPages(200);
        BookDto dto = RetrieveBookMapper.toDto(book);
        assertNull(dto.getReadingPercentage());
    }

    @Test
    public void testPositiveWithPublisherData(){
        var publisher = new Publisher();
        publisher.setName("OReilly");
        publisher.setRegistrationNumber("9826238484944");
        var address = new Address();
        address.setCity("Arizona");
        address.setLine1("Street 2 Manu Square");
        address.setLine2("House 12");
        address.setPinCode(457722);
        publisher.setAddress(address);
        String s = RetrieveBookMapperImproved.formatPublisherAddress(publisher);
        assertEquals("Street 2 Manu Square,House 12,Arizona,457722",s);

    }
    @Test
    public void testNegativeWithNoPinCode(){
        var publisher = new Publisher();
        publisher.setName("OReilly");
        publisher.setRegistrationNumber("9826238484944");
        var address = new Address();
        address.setCity("Arizona");
        address.setLine1("Street 2 Manu Square");
        address.setLine2("House 12");
        publisher.setAddress(address);
        String s = RetrieveBookMapperImproved.formatPublisherAddress(publisher);
        assertEquals("Street 2 Manu Square,House 12,Arizona",s);

    }

    @Test
    public void testNegativeWithNoLine2(){
        var publisher = new Publisher();
        publisher.setName("OReilly");
        publisher.setRegistrationNumber("9826238484944");
        var address = new Address();
        address.setCity("Arizona");
        address.setLine1("Street 2 Manu Square");
        address.setPinCode(457722);
        publisher.setAddress(address);
        String s = RetrieveBookMapperImproved.formatPublisherAddress(publisher);
        assertEquals("Street 2 Manu Square,Arizona,457722",s);

    }

    @Test
    public void testNegativeWithNoPublisherAddress(){
        var publisher = new Publisher();
        publisher.setName("OReilly");
        publisher.setRegistrationNumber("9826238484944");
        String s = RetrieveBookMapperImproved.formatPublisherAddress(publisher);
        assertEquals("No Publisher Address",s);
    }

    @Test
    public void testNegativeWithNoPublisherData(){
        String s = RetrieveBookMapperImproved.formatPublisherAddress(null);
        assertEquals("No Publisher Address",s);
    }
    @Test
    public void testBookPrice(){
        Book book = new Book();
        book.setIsbn("97321114144");
        book.setGenre("Technical");
        book.setLanguage("English");
        book.setPages(200);
        var totalPrice = new ArrayList<Price>();
        Price printingPrice = new Price();
        printingPrice.setActualPrice(10.00);
        printingPrice.setType(PriceType.PRINTING);
        totalPrice.add(printingPrice);
        Price distributionPrice = new Price();
        distributionPrice.setActualPrice(10.00);
        distributionPrice.setType(PriceType.DISTRIBUTION);
        totalPrice.add(distributionPrice);
        Price royalitiesPrice = new Price();
        royalitiesPrice.setActualPrice(10.00);
        royalitiesPrice.setType(PriceType.ROYALTIES);
        totalPrice.add(royalitiesPrice);
        book.setPrices(totalPrice);

        BookDto dto = RetrieveBookMapperImproved.toDto(book);

        Assertions.assertEquals("30.0",dto.getPrice());
       

    }

    @Test
    public void testBookPriceWithNoData(){
        Book book = new Book();
        book.setIsbn("97321114144");
        book.setGenre("Technical");
        book.setLanguage("English");
        book.setPages(200);
        BookDto dto = RetrieveBookMapperImproved.toDto(book);
        Assertions.assertEquals("Price not Available",dto.getPrice());
    }
}
