package com.abc.bookstore;

import com.abc.bookstore.exception.BusinessException;
import com.abc.bookstore.response.RetrieveBooksResponse;
import com.abc.bookstore.service.RetrieveBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/{customerId}/books")
public class RetrieveBookController {

    RetrieveBookService retrieveBookService;

    public RetrieveBookController(RetrieveBookService retrieveBookService) {
        this.retrieveBookService = retrieveBookService;
    }


    @GetMapping
    public RetrieveBooksResponse retrieveBooksHistory(@PathVariable String customerId) throws BusinessException {
        return retrieveBookService.retrieveBooks(customerId);
    }
}
