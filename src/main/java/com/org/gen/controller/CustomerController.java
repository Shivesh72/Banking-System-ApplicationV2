package com.org.gen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.org.gen.models.Customer;
import com.org.gen.repo.CustomerRepository;
import com.org.gen.services.CustomerService;


@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/add")
	public Customer addUser()
	{

		Customer customer  = new Customer();
		customer.setEmail("abc@gmail.com");
		customer.setMobileNumber("998877665544");
		customer.setName("John");
		customer.setPassword("12345#");
		
		Customer temp =  this.customerService.CreateCustomer(customer);
		System.out.println(temp.getEmail());
		return temp;
		
	}
	
	@Autowired
	private CustomerRepository repo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("customer",new Customer());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(Customer cust) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPassword=  encoder.encode(cust.getPassword());
		cust.setPassword(encodedPassword);
		repo.save(cust);
		return "registration_success";
	}
	
	@GetMapping("/list_customers")
	public String viewUsersList(Model model) {
		List<Customer> listCustomers = repo.findAll();
		model.addAttribute("listCustomer", listCustomers);
		return "customers";
	}
}
