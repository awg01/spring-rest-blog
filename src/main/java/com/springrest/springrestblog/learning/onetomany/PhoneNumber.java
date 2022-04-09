package com.springrest.springrestblog.learning.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String number;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
}
