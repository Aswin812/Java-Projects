package com.emailApplication;

import com.emailApplication.mails.login.Login;

public class EmailApplication {

	public static void main(String[] args) {
		
		System.out.println("******** Email Application ********");
		System.out.println();
		Login obj=new Login();
		
		obj.login();		
	}

}
