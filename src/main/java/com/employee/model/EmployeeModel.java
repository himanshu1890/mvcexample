package com.employee.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeModel {
	
	private String greet;
	
	@Size(min=3,max=20) //validation rule in code directly rather than creating validation class
	private String firstName;
	
	@Size(min=2,max=20)
	private String lastName;
	
	@Pattern(regexp=".+@.+.[a-z]+")
	private String address;
	
	
	
	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	public void setHello(String greet) {
		this.greet=greet;
	}

	public String getHello() {
		return greet;
	}
}
