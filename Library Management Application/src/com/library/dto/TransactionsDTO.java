package com.library.dto;

public class TransactionsDTO {

	private String userName;
	private String bookTitle;
	private String borrowOrReturn;
	
	
	public TransactionsDTO(String userName, String title, String borrowOrReturn) {
		this.userName=userName;
		this.bookTitle=title;
		this.borrowOrReturn=borrowOrReturn;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBorrowOrReturn() {
		return borrowOrReturn;
	}
	public void setBorrowOrReturn(String borrowOrReturn) {
		this.borrowOrReturn = borrowOrReturn;
	}
	
}
