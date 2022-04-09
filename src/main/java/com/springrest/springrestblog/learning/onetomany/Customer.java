package com.springrest.springrestblog.learning.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) //it tells that primary key is in the customer
	private Set<PhoneNumber> numbers;
	
	public void addPhoneNumber(PhoneNumber number) {
		if(number != null) {
			if(numbers == null) {
				numbers = new HashSet<>();
			}
			number.setCustomer(this);
			numbers.add(number);
			numbers.forEach((e) -> { System.out.println(e.getNumber()); });
			
		}
	}
	
}
