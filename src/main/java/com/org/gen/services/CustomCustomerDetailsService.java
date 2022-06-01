package com.org.gen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.org.gen.models.Customer;
import com.org.gen.repo.CustomerRepository;


public class CustomCustomerDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Customer cust = repo.findByEmail(email);
		if(cust==null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomCustomerDetails(cust);
	}

}
