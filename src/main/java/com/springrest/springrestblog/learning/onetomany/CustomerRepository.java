package com.springrest.springrestblog.learning.onetomany;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository  extends CrudRepository<Customer, Long>{

}
