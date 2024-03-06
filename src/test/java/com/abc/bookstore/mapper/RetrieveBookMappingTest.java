package com.abc.bookstore.mapper;

import com.abc.bookstore.models.*;
import com.abc.bookstore.response.BookDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RetrieveBookMappingTest {

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

    /*@Test
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
        String s = RetrieveBookMapper.formatPublisherAddress(publisher);
        assertEquals("Street 2 Manu Square ,House 12 ,Arizona ,457722",s);

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
        String s = RetrieveBookMapper.formatPublisherAddress(publisher);
        assertEquals("Street 2 Manu Square ,House 12 ,Arizona",s);

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
        String s = RetrieveBookMapper.formatPublisherAddress(publisher);
        assertEquals("Street 2 Manu Square ,Arizona ,457722",s);

    }*/

}
