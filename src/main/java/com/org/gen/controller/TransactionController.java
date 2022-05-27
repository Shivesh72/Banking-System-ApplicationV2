package com.org.gen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.gen.models.Transaction;
import com.org.gen.repo.TransactionRepository;

@RestController("/")
public class TransactionController {
	
	@Autowired
	private TransactionRepository repo;
	
	@RequestMapping("/addT")
	public Transaction addTransaction()
	{

		Transaction transaction = new Transaction();
		transaction.setAccount_id(123);
//		transaction.setTrans_id(1002);
		transaction.setAmount(20000);
		transaction.setType(2); //1 for deposit 2 for withdrawal 3 for transfer
		
		Transaction tr = repo.save(transaction); 
		System.out.println(tr.getTrans_id());
		return tr;
		
	}
}
