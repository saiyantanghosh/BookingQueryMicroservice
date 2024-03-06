package com.abc.bookstore.dao;

import com.abc.bookstore.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query("{customerId:'?0'}")
    Optional<Customer> findCustomerByCustomerId(String customerId);
}
