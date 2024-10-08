package com.library.screens.admin;

import java.util.List;
import java.util.Map;

import com.library.dataLayer.Repository;
import com.library.dto.BookDTO;
import com.library.dto.TransactionsDTO;
import com.library.dto.UserDTO;

public class AdminViewModel {
//	int bookId=100;
	
	private Admin view;
	
	public AdminViewModel(Admin view) {
		this.view=view;
	}
	
	
	void addBook(String title, String isbn, String author, int price) {
		Repository.getInstance().addBook(title, isbn, author, price);
	}
	
	boolean removeBook(String title) {
		return Repository.getInstance().removeBook(title);
	}
	
	List<BookDTO> getBookList(){
		return Repository.getInstance().getBookList();
	}
	
	List<UserDTO> getUserList(){
		return Repository.getInstance().getUserList();
	}
	
	Map<String, List<BookDTO>> getBorrowedBooks() {
		return Repository.getInstance().getBorrowedBooks();
	}
	
	List<TransactionsDTO> getTransactionHistory(){
		return Repository.getInstance().getTransactionHistory();
	}
	
	
	boolean removeUser(int id) {
		return Repository.getInstance().removeUser(id);
	}
	
}
