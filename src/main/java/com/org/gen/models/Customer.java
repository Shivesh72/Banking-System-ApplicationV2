package com.org.gen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Employee")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_ID;
	
	@Column(nullable = false,length = 30)
	private String name;
	

	@Column(nullable = false,length=64)
	private String password;
	
	@Column(nullable = false,length = 10)
	private String mobileNumber;
	
	@Column(nullable = false,length = 30)
	private String email;
	
	@Column(nullable = false,length=10)
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEmp_ID() {
		return emp_ID;
	}
	public void setEmp_ID(int emp_ID) {
		this.emp_ID = emp_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Customer(int emp_ID, String name, String password, String mobileNumber, String email,
			String status) {
		super();
		this.emp_ID = emp_ID;
		this.name = name;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		
		this.status = status;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
