package com.theatreApplication.screens.login;

import com.theatreApplication.screens.Input;
import com.theatreApplication.screens.admin.Admin;
import com.theatreApplication.screens.user.User;

public class Login {
	int count=0;
	
	private LoginViewModel viewModel;
	
	public Login() {
		viewModel=new LoginViewModel(this);
	}
	
	public void login() {
		int inp=0;
		
		do {
			System.out.println("1. Create Account");
			System.out.println("2. Sign In");
			System.out.println("3. Exit");
			
			inp=Input.getInstance().getInt();
			switch(inp) {
			case 1:
				createAccount();
				break;
			case 2:
				signIn();
				break;
			case 3:
				System.out.println("Thank You");
				break;
			default :
				System.out.println("Enter Valid Input");
			}
			
		}while(inp!=3);
	}
	

	void createAccount() {
		count++;
		if(count==4) {
			count=0;
			return;
		}
		System.out.println("Enter UserName : ");
		String name=Input.getInstance().getString();
		if(!viewModel.validName(name)) {
			System.out.println("Enter Valid Name");
			createAccount();
		}
		System.out.println("Enter Email Id : ");
		String email=Input.getInstance().getString();
		if(!viewModel.validEmail(email)) {
			System.out.println("Enter Valid Email");
			createAccount();
		}
		System.out.println("Enter Password : ");
		String password=Input.getInstance().getString();
		System.out.println("Enter DOB : ");
		String dob=Input.getInstance().getString();
		System.out.println("Enter Phone Number : ");
		String mobileNumber=Input.getInstance().getString();
		
		viewModel.createAccount(name, email, password, dob, mobileNumber); 
		System.out.println("Account Create Successfully...");
		System.out.println();
		new User().userPage(email);
		
	}
	
	void signIn() {
		count++;
		if(count==4) {
			count=0;
			return;
		}
		System.out.println("Enter Email : ");
		String email=Input.getInstance().getString();
		System.out.println("Enter Password : ");
		String password=Input.getInstance().getString();
		
		if(viewModel.isAdmin(email, password)) {
			Admin.getInstance().adminWorks();
		}
		else {
			if(viewModel.verify(email, password)) {
				new User().userPage(email); 
			}
			else {
				System.out.println("Email (or) Password are Incorrect...");
				signIn();
			}			
		}
		
	}
}
