package com.theatreApplication.screens.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.theatreApplication.dataLayer.Repository;

public class LoginViewModel {
	
	private static String adminEmail="admin@gmail.com";
	private static String adminPassword="1234";
	
	private Login view;
	public LoginViewModel(Login view) {
		this.view=view;
	}
	
	boolean isAdmin(String userName, String password) {
		return userName.equals(adminEmail)&&password.equals(adminPassword);
	}

	public void createAccount(String name, String email, String password, String dob, String number) {
		Repository.getInstance().createAccount(name, email, password, dob, number);
	}
	
	public boolean verify(String email, String password) {
		return Repository.getInstance().verifyEmail(email, password);
	}
	
	public boolean validName(String name) {
		name.trim();
		for(int i=0; i<name.length(); i++) {
			if(!Character.isLetter(name.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validEmail(String email) {
		String str="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern p=Pattern.compile(str);
		Matcher m=p.matcher(email);
		return m.matches();
	}
}
