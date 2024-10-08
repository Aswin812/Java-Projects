package com.library.dto;


public class UserDTO {
	private static int count=1000;
	private String userName;
	private String email;
	private String password;
	private int age;
	private String mobileNumber;
	private int userId;
//	private List<Book> borrowedBooks;

	
	
	public UserDTO(String name, String email, String password, int age, String number) {
		userName=name;
		this.password=password;
		userId=count++;
		mobileNumber=number;
//		borrowedBooks=new ArrayList<>();
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getAge() {
		return age;
	}

	public int getUserId() {
		return userId;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
}
