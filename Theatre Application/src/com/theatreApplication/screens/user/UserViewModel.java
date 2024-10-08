package com.theatreApplication.screens.user;

import com.theatreApplication.dataLayer.Repository;

public class UserViewModel {

	private User view;
	UserViewModel(User view){
		this.view=view;
	}
	
	boolean containsMovie(String movieName) {
		return Repository.getInstance().containsMovie(movieName);
	}
	
	void bookTicket(String email, String movieName, String seatNum) {
		int row=seatNum.charAt(0)-'A';
		int col=Integer.parseInt(seatNum.substring(1, seatNum.length()));
		Repository.getInstance().bookTicket(email, movieName, seatNum, row, col);
	}
	
	boolean validSeatNum(String seatNum) {
		char row=seatNum.charAt(0);
		int col=Integer.parseInt(seatNum.substring(1, seatNum.length()));
		if(row<65&&row>90) return false;
		if(col<1&&col>35)return false;
		return true;
	}
	
	boolean isValidSeat(String movieName, String seatNum) {
		return Repository.getInstance().isValidSeat(movieName, seatNum);
	}
	
	boolean checkUserHaveTicket(String email) {
		return Repository.getInstance().checkUserHaveTicket(email);
	}
	
	void cancelTicket(String email, String movieName, String seatNum) {
		int row=seatNum.charAt(0)-'A';
		int col=Integer.parseInt(seatNum.substring(1, seatNum.length()));
		Repository.getInstance().cancelTicket(email, movieName, seatNum, row, col);
	}
	
	
	
	
	
	
}
