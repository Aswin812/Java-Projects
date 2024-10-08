package com.library.dataLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.dto.BookDTO;
import com.library.dto.TransactionsDTO;
import com.library.dto.UserDTO;

public class Repository {
	
	private static Repository repository;
	public static Repository getInstance() {
		if(repository==null)
			repository= new Repository();
		return repository;
	}
	
	
	List<BookDTO> books=new ArrayList<>();
	List<UserDTO> accounts=new ArrayList<>();
	Map<String, List<BookDTO>> borrowBooks=new HashMap<>();
	List<TransactionsDTO> transactions=new ArrayList<>();
	
	
	
	public void createAccount(String name, String email, String password, int age, String number) {
		accounts.add(new UserDTO(name, email, password, age, number));
	}
	
	public boolean removeUser(int id) {
		for(UserDTO user:accounts) {
			if(user.getUserId()==id) {
				accounts.remove(user);
				return true;
			}
		}
		return false;
	}
	
	public void addBook(String title, String isbn, String author, int price) {
		books.add(new BookDTO(title, isbn, author, price));
	}
	
	public boolean removeBook(String isbn) {
		for(BookDTO book: books) {
			if(book.getIsbn().equals(isbn)) {
				books.remove(book);
				return true;
			}
		} 
		return false;
//		return books.remove(id, books.get(id));
	}
	
	public List<BookDTO> getBookList() {
		return books;
	}
	
	public List<UserDTO> getUserList() {
		return accounts;
	}
	
	public Map<String, List<BookDTO>> getBorrowedBooks() {
		return borrowBooks;
	}
	
	public List<TransactionsDTO> getTransactionHistory(){
		return transactions;
	}
	
	public boolean accountVerify(int userId, String password) {
		for(UserDTO user: accounts) {
			if(user.getUserId()==userId&&user.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	public BookDTO containsBook(String title) {
		for(BookDTO book:books) {
			if(book.getTitle().equals(title)) {  
				return book;
			}
		}
		return null;
	}
	
	public boolean checkBorrowBook(String userName, String title) {
		List<BookDTO> list=borrowBooks.get(userName);
		for(BookDTO book: list) {
			if(book.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyBorrowBookUser(String userName) {
		return borrowBooks.containsKey(userName);
	}
	
	public void returnBook(String name, String title) {
		List<BookDTO> borrowbooks=borrowBooks.get(name);
		for(BookDTO book: borrowbooks) {
			if(book.getTitle().equals(title)) {
				borrowbooks.remove(book);
				borrowBooks.put(name, borrowbooks);
				return ;
			}
		}
	}
	 
	public void addBorrowedBook(String userName, BookDTO book) {
		List<BookDTO> borrowBook=borrowBooks.getOrDefault(userName, new ArrayList<>());
		borrowBook.add(book);
		borrowBooks.put(userName, borrowBook);
	}
	
	public void updateTransactionHistory(String userName, String title, String borrowOrReturn) {
		transactions.add(new TransactionsDTO(userName, title, borrowOrReturn));
	}
	
	
}
