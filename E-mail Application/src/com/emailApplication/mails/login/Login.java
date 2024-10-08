package com.emailApplication.mails.login;

import com.emailApplication.mails.Input;
import com.emailApplication.mails.user.User;

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
			System.out.println("2. Login");
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
				System.out.println("Thank You...");
				break;
			default:
				System.out.println("Enter Valid Input");
			}
		}while(inp!=3);
	}
	
	private void createAccount() {
		count++;
		if(count==4) {
			count=0;
			return;
		}
		System.out.println("Enter User Name : ");
		String userName=Input.getInstance().getString();
		if(!viewModel.validName(userName)) {
			System.out.println("Enter Valid UserName");
			return;
		}
		System.out.println("Enter Email Id : ");
		String email=Input.getInstance().getString();
		if(!viewModel.validEmail(email)) {
			System.out.println("Enter Valid Email");
			return;
		}
		System.out.println("Enter Password : ");
		String password=Input.getInstance().getString();
		System.out.println("Enter Age : ");
		int age=Input.getInstance().getInt();
		System.out.println("Enter Gender : (male / female)");
		String gender=Input.getInstance().getString();
		
		viewModel.createAccount(userName, email, password, age, gender);
		System.out.println("Account Create Successfully");
		System.out.println();
		new User().userView(email);
		count=0;
	}
	
	private void signIn() {
		count++;
		if(count==4) {
			count=0;
			return;
		}
		System.out.println("Enter Email : ");
		String email=Input.getInstance().getString();
		System.out.println("Enter Password : ");
		String password=Input.getInstance().getString();
		   
		if(viewModel.emailVerification(email, password)) {
			new User().userView(email);
		}
		else { 
			System.out.println("Email (or) Password are Incorrect...");	
			signIn();
		}
		count=0;
	}
	
}

