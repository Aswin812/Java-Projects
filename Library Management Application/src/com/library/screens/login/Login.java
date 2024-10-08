package com.library.screens.login;

import com.library.dataLayer.Repository;
import com.library.screens.Input;
import com.library.screens.admin.Admin;
import com.library.screens.users.User;

public class Login {
	
//	static {
//		Repository.getInstance().addBook("Harry Potter 1", "12345678", "Aswin", 1000);
//		Repository.getInstance().addBook("Harry Potter 2", "22345678", "Aswin", 1000);
//		Repository.getInstance().addBook("Harry Potter 3", "32345678", "Aswin", 1000);
//	}
	
	private LoginViewModel viewModel;
	public Login() {
		viewModel=new LoginViewModel(this);
	}
	
	User user=new User();
	
	public void login() {
		
		int num=0;
		do {
			System.out.println("1. Login as Admin");
			System.out.println("2. Login as User");
			System.out.println("3. Exit");
			
			num=Input.getInstance().getInt();
			
			switch(num) {
			case 1:
				adminLogin();
				break;
			case 2:
				userLogin();
				break;
			case 3:
				System.out.println("-----Thank You-----");
				break;
			default:
				System.out.println("Enter Valid Number...");
			}
		}while(num!=3);
	}
	
	private void adminLogin() {
		System.out.println("Enter Name : ");
		String name=Input.getInstance().getString();
		System.out.println("Enter Password : ");
		String password=Input.getInstance().getString();
		
		if(viewModel.validAdmin(name, password)) {
			Admin.getInstance().adminWorks();
		}
		else {
			System.out.println("User Name  (or)  Password are Incorrect...");
			return;
		}
	}
  
	private void userLogin() {
		int num=0;
		
		do {
			System.out.println("1. Create Account");
			System.out.println("2. Already have Account");
			
			num=Input.getInstance().getInt();
			switch(num) {
			case 1:
				createAccount();
				break;
			case 2:
				signIn();
				break;
			default:
				System.out.println("Enter Valid Input");
			}
			
		}while(num!=1&&num!=2);
	}
	
	
	private void createAccount() {
		System.out.println("Enter UserName : ");
		String name=Input.getInstance().getString();
		System.out.println("Enter Email : ");
		String email=Input.getInstance().getString();
		System.out.println("Enter Password : ");
		String password=Input.getInstance().getString();
		System.out.println("Enter Age : ");
		int age=Input.getInstance().getInt();
		System.out.println("Enter Mobile Number : ");
		String mobileNumber=Input.getInstance().getString();
		
		viewModel.createAccount(name, email, password, age, mobileNumber); 
		System.out.println("Account Created Successfully...");
		System.out.println();
		user.userPage(name);
		
	}

	private void signIn() {
		System.out.println("Enter User Id : ");
		int id=Input.getInstance().getInt();
		System.out.println("Enter Password : ");
		String password=Input.getInstance().getString();
				
		if(viewModel.validUser(id, password)) {
			user.userPage("Aswin");
		}
		else {
			System.out.println("UserName (or) Password are Incorrect...");
		}
	}
}
