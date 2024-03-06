package com.abc.bookstore.service;

import com.abc.bookstore.dao.CustomerRepository;
import com.abc.bookstore.exception.BusinessException;
import com.abc.bookstore.mapper.RetrieveBookMapper;
import com.abc.bookstore.mapper.RetrieveBookMapperImproved;
import com.abc.bookstore.models.Customer;
import com.abc.bookstore.response.BookDto;
import com.abc.bookstore.response.RetrieveBooksResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RetrieveBookServiceImpl implements RetrieveBookService {
    private final CustomerRepository customerRepository;
    public RetrieveBookServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public RetrieveBooksResponse retrieveBooks(String customerId) throws BusinessException {
        RetrieveBooksResponse retrieveBooksHistoryResponse = new RetrieveBooksResponse();
        Optional<Customer> customerEntity = customerRepository.findCustomerByCustomerId(customerId);
        customerEntity.ifPresent((customer)->{
            List<BookDto> booksDto = customer
                    .getReadingBooks()
                    .stream()
                    .map(RetrieveBookMapperImproved::toDto)
                    .collect(Collectors.toList());
            retrieveBooksHistoryResponse.setBooks(booksDto);
        });
        customerEntity.orElseThrow(()->new BusinessException("ERR001","Customer Not Found"));
        return retrieveBooksHistoryResponse;
    }

    /*@Override
    // previous code
    public RetrieveBooksHistoryResponse retrieveBooksHistory(String customerId) throws BusinessException {

        //verbose code
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);
        if(customer!=null){
            List<BookDto> booksDto = customer.getReadingBooks().stream().map(RetrieveBookMapper::toDto).collect(Collectors.toList());
            RetrieveBooksHistoryResponse retrieveBooksHistoryResponse = new RetrieveBooksHistoryResponse();
            retrieveBooksHistoryResponse.setBooks(booksDto);
            return retrieveBooksHistoryResponse;
        }else{
            throw new BusinessException("100","Customer Not Found");
        }

    }*/
}
