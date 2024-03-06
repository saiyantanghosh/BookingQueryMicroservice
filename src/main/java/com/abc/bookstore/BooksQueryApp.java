package com.abc.bookstore;

import com.abc.bookstore.dao.CustomerRepository;
import com.abc.bookstore.models.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class BooksQueryApp {
	private static final Logger LOG = LoggerFactory.getLogger(BooksQueryApp.class);
	@Autowired
	CustomerRepository repository;
	@Value("classpath:data.json")
	Resource resourceFile;

	public static void main(String[] args) {
		SpringApplication.run(BooksQueryApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			LOG.info("Let's setup customer data");

			loadCustomerData();

		};
	}

	void loadCustomerData()  {
		LOG.info("Data creation started...");
        try(InputStream inputStream = resourceFile.getInputStream()) {
			ObjectMapper mapper = new ObjectMapper();
			var customersData = mapper.readValue(inputStream,new TypeReference<List<Customer>>(){});
			customersData.forEach(x->{
				var customer = repository.findCustomerByCustomerId(x.getCustomerId());
				customer.orElseGet(()->repository.save(x));
			});
		}catch (Exception ex){
			LOG.error("Customer Data Loading Error",ex);
		}
		LOG.info("Data creation complete...");
	}

}
