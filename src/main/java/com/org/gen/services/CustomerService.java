package com.org.gen.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.gen.models.Customer;
import com.org.gen.repo.CustomerRepository;

@Service
public class CustomerService  {

	@Autowired 
	private CustomerRepository customerRepository;
	
	public Customer CreateCustomer(Customer customer)
	{
		
		Customer  tempCust = this.customerRepository.save(customer);
		
		return tempCust;
		
	}
	public List<Customer> showCustomer()
	{
		List<Customer> list=(List<Customer>)customerRepository.findAll();
		return list;
	}
	
	
	
}
