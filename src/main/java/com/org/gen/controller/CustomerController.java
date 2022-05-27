package com.org.gen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.gen.models.Customer;
import com.org.gen.services.CustomerService;

@RestController("/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/add")
	public Customer addUser()
	{

		Customer customer  = new Customer();
		customer.setCust_ID(101);
		customer.setEmail("abc@gmail.com");
		customer.setMobileNumber("998877665544");
		customer.setName("John");
		customer.setPassword("12345#");
		
		Customer temp =  this.customerService.CreateCustomer(customer);
		System.out.println(temp.getEmail());
		return temp;
		
	}
}
