package com.library.screens.users;


import com.library.dataLayer.Repository;
import com.library.dto.BookDTO;

public class UserViewModel {
	
	private User view;
	public UserViewModel(User view) {
		this.view=view;
	}
	
	BookDTO containsBook(String title) {
		return Repository.getInstance().containsBook(title);
	}
	
	
	void addBorrowedBook(String name, BookDTO book) {
		Repository.getInstance().addBorrowedBook(name, book);
	}
	
	boolean verifyBorrowBookUser(String userName) {
		return Repository.getInstance().verifyBorrowBookUser(userName);
	}
	
	void returnBook(String name, String title) {
		Repository.getInstance().returnBook(name, title);
	}
	
	boolean checkBorrowBook(String userName, String title) {
		return Repository.getInstance().checkBorrowBook(userName, title);
	}
	
	void updateTransactionHistory(String userName, String title, String borrowOrReturn) {
		Repository.getInstance().updateTransactionHistory(userName, title, borrowOrReturn); 
	}
	
}
