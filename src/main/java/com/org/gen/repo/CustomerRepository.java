package com.org.gen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.gen.models.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	@Query("SELECT u FROM Customer u WHERE u.email = ?1")
	Customer findByEmail(String email);
}
