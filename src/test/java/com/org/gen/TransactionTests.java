package com.org.gen;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.org.gen.models.Customer;
import com.org.gen.models.Transaction;
import com.org.gen.repo.CustomerRepository;
import com.org.gen.repo.TransactionRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TransactionTests {

	@Autowired
	private TransactionRepository repo;
	
	@Autowired
	private CustomerRepository cRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateTransaction() {
	//this function helps in testing my transaction model
		Transaction transaction = new Transaction();
		transaction.setAccount_id(123);
//		transaction.setTrans_id(1002);
		transaction.setAmount(20000);
		transaction.setType(2); //1 for deposit 2 for withdrawal 3 for transfer
		
		//saving the transaction in DB
		Transaction savedTransaction = repo.save(transaction);
		Transaction existTransaction = entityManager.find(Transaction.class, savedTransaction.getTrans_id());
		assertThat(existTransaction.getAccount_id()).isEqualTo(transaction.getAccount_id());
	}
	@Test
	public void testCustomer() {
		Customer customer= new Customer();
		customer.setEmail("shiv@gmail.com");
		customer.setMobileNumber("9977665532");
		customer.setName("Shiv");
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPassword=  encoder.encode("1234");
		customer.setPassword(encodedPassword);
		customer.setStatus("pending");
		Customer savedCustomer= cRepository.save(customer);
		
		Customer find = entityManager.find(Customer.class, savedCustomer.getEmp_ID());
		List<Customer> list=(List<Customer>)cRepository.findAll();
		System.out.print(list);	
		}
}
