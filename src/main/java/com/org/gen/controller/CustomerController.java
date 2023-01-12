package com.org.gen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.org.gen.models.Customer;
import com.org.gen.repo.CustomerRepository;
import com.org.gen.services.CustomerService;


@RestController("/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/add")
	public Customer addUser()
	{

		Customer customer  = new Customer();
		customer.setEmail("abc@gmail.com");
		customer.setMobileNumber("9988776688");
		customer.setName("John");
		customer.setPassword("12345#");
		customer.setStatus("pending");
		
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
	
	@GetMapping("/show")
	public List<Customer> showCustomers()
	{
		
		return customerService.showCustomer();
	}
	@PostMapping("/addNew")
	public Customer addCustomer(@RequestBody Customer cust)
	{
		System.out.println("Accepted"+ " "+cust.getName());
		Customer temp =  this.customerService.CreateCustomer(cust);
		System.out.println(temp.getEmail());
		return temp;
//		return "Added";
	}
	
	
	
	
	
	
	
	
	
	@PostMapping("/process_register")
	public String processRegistration(Customer cust) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPassword=  encoder.encode(cust.getPassword());
		cust.setPassword(encodedPassword);
		cust.setStatus("pending");
		repo.save(cust);
		return "registration_success";
	}
	
	@GetMapping("/list_customers")
	public String viewUsersList(Model model) {
		List<Customer> listCustomers = repo.findAll();
		model.addAttribute("listCustomers", listCustomers);
		return "customers";
	}
}
