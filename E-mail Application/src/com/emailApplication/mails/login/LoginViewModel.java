package com.emailApplication.mails.login;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.emailApplication.dataLayer.Repository;

class LoginViewModel {
	
	private Login view;
	public LoginViewModel(Login view) {
		this.view=view;
		
	}

	void createAccount(String name, String email, String password, int age, String gender) {
		Repository.getInstance().createAccount(name, email, password, age, gender);
	}
	
	boolean emailVerification(String email, String password) {
		if(Repository.getInstance().emailVerification(email, password)) {
			return true;
		}
		return false;
	}
	
	boolean validName(String name) {
		name.trim();
		for(int i=0; i<name.length(); i++) {
			if(!Character.isLetter(name.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	boolean validEmail(String email) {
		String str="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern p=Pattern.compile(str);
		Matcher m=p.matcher(email);
		return m.matches();
	}
	
}

