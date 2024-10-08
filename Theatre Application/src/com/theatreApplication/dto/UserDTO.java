package com.theatreApplication.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
	private String name;
	private String email;
	private String password;
	private String dob;
	private String mobileNumber;
	
	
	
	public UserDTO(String name, String email, String password, String dob, String number) {
		this.name=name;
		this.email=email;
		this.password=password;
		this.dob=dob;
		this.mobileNumber=number;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
