package com.gcu.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserModel {
	
	@NotBlank(message = "Username is mandatory")
	@Size(min=5, max=32, message="You Must have over 5 and under 32 characters")
	private String username;
	@NotBlank(message = "Password is mandatory")
	@Size(min=5, max=32, message="You Must have over 5 and under 32 characters")
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
