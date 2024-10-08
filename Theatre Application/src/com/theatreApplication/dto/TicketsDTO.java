package com.theatreApplication.dto;

public class TicketsDTO {
	private String movieName;
	private String userEmail;
//	private String showTime;
	private String seatNum;
	
	
	public TicketsDTO(String movieName, String email, String seatNum) {
		this.movieName=movieName;
		this.userEmail=email;
//		this.showTime=time;
		this.seatNum=seatNum;
	}
	
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
//	public String getShowTime() {
//		return showTime;
//	}
//	public void setShowTime(String showTime) {
//		this.showTime = showTime;
//	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	
	
}
