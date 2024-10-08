package com.library.screens.login;

import com.library.dataLayer.Repository;
import com.library.dto.UserDTO;

public class LoginViewModel {

	static String adminName="Aswin";
	static String adminPassword="1234";
	
	private Login view;
	public LoginViewModel(Login view) {
		this.view=view;
	}
	
	boolean validAdmin(String name, String password) {
		return name.equals(adminName)&&password.equals(adminPassword);
	}
	
	void createAccount(String name, String email, String password, int age, String mobileNumber) {
		Repository.getInstance().createAccount(name, email, password, age, mobileNumber);
	}
	
	boolean validUser(int id, String password) {
		return Repository.getInstance().accountVerify(id, password);
	}
}
