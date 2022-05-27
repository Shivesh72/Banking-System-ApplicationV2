package com.org.gen.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.gen.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
