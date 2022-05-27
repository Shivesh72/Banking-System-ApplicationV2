package com.org.gen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.gen.models.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query("SELECT u FROM Transaction u WHERE u.account_id = ?1")
	Transaction findByAccount_id(long account_id);
	
}
