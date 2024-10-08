package com.library.dto;

import java.util.ArrayList;
import java.util.List;

public class BookDTO {
	private String title;
	private String isbn;
	private String author;
	private int price;
//	private boolean isAvailable;
	
	
	
	public BookDTO(String title, String isbn, String author, int price) {
		this.title=title;
		this.isbn=isbn;
		this.author=author;
		this.price=price;
	}
	
	
	
	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getAuthor() {
		return author;
	}


	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}



}
