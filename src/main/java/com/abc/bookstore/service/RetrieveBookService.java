package com.abc.bookstore.service;

import com.abc.bookstore.exception.BusinessException;
import com.abc.bookstore.response.RetrieveBooksResponse;

public interface RetrieveBookService {
    RetrieveBooksResponse retrieveBooks(String customerId) throws BusinessException;
}
