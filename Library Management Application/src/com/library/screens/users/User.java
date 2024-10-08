package com.library.screens.users;


import com.library.dto.BookDTO;
import com.library.screens.Input;
import com.library.screens.admin.Admin;

public class User {
	int amount=0;
	private UserViewModel viewModel;
	public User() {
		viewModel=new UserViewModel(this);
	}
	
	public void userPage(String userName) {
		int inp=0;
		
		do {
			System.out.println("1. Borrow Book");
			System.out.println("2. Return Book");
			System.out.println("3. Back");
			
			inp=Input.getInstance().getInt();
			
			switch(inp) {
			case 1:
				borrowBook(userName);
				break;
			case 2:
				returnBook(userName);
				break;
			case 3:
				System.out.println("Thank You");		
				break;
			default:
				System.out.println("Enter Valid Input");
			}
		}while(inp!=3);
	}
	
	private void borrowBook(String userName) {
		Admin.getInstance().viewBookList();
		
		BookDTO book;
		
		System.out.println("Enter Book Title : ");
		String title=Input.getInstance().getString();
		book=viewModel.containsBook(title);
		if(book==null) {
			System.out.println("This Book not Available");
			return ;
		}

		amount+=book.getPrice();

		viewModel.addBorrowedBook(userName, book);
		viewModel.updateTransactionHistory(userName, title, "Borrow");
		
		int inp=0;
		
		do {
			System.out.println("1. Borrow other Book  (or)  2. Finish");
			inp=Input.getInstance().getInt();
			
			switch(inp) {
			case 1:
				borrowBook(userName);
				break;
			case 2:
				System.out.println("Total Amount is "+amount);
				System.out.println("Thank You...");
				break;
			default :
				System.out.println("Enter valid input");
			}
		}while(inp!=1&&inp!=2);
		amount=0;
	}

	private void returnBook(String name) {
		if(!viewModel.verifyBorrowBookUser(name)) {
			System.out.println("Books not Borrowed");
			return ;
		}
		System.out.println("Enter Book Title : ");
		String title=Input.getInstance().getString();
		if(!viewModel.checkBorrowBook(name, title)) {
			System.out.println("This Book Not Borrowed !");
			return ;
		}
		viewModel.returnBook(name, title);
		viewModel.updateTransactionHistory(name, title, "Return");
		System.out.println();
		System.out.println("Book Returned");
		System.out.println();
	}
	
}
