package com.springrest.springrestblog;

import java.util.HashSet;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springrest.springrestblog.learning.onetomany.Customer;
import com.springrest.springrestblog.learning.onetomany.CustomerRepository;
import com.springrest.springrestblog.learning.onetomany.PhoneNumber;

@SpringBootTest
class SpringRestBlogApplicationTests {
	
	@Autowired
	CustomerRepository repository;
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("akash");
		
		HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
		
		PhoneNumber n1 = new PhoneNumber();
		n1.setNumber("9123456789");
		n1.setType("cell");
		
		PhoneNumber n2 = new PhoneNumber();
		n2.setNumber("9923456789");
		n2.setType("home");
		
		customer.addPhoneNumber(n1);
		customer.addPhoneNumber(n2);
		repository.save(customer);
	}
	
	@Test
	@Transactional
	public void testLoadCustomer() {
		Optional<Customer> customer = repository.findById(1L);
		System.out.println(customer.get());
	}
	
	@Test
	public void testUpdateCustomer() {
//		Optional<Customer> customer = repository.findById(1L);
//		customer.get((customer)->{customer.setName("user");});
	}
	
	@Test
	public void testDelteCustomer() {
		repository.deleteById(2L);
	}

}
