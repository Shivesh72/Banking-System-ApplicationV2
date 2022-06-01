package com.org.gen.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.org.gen.models.Customer;


public class CustomCustomerDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Customer cust;
	
	public CustomCustomerDetails(Customer customer) {
		super();
		this.cust=customer;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return cust.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return cust.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public String getFullname() {
		return cust.getName();
	}

}
