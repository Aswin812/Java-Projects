package com.theatreApplication.dto;

public class MovieDTO {

	private int movieId;
	private String movieName;
	private String movieType;
	private String movieDescription;
	private int ticketPrice;
	char[][] screen;
	
	public MovieDTO(int id, String name, String type, String description, int price, char[][] screen) {
		this.movieId=id;
		this.movieName=name;
		this.movieType=type;
		this.movieDescription=description;
		this.ticketPrice=price;
		this.screen=screen;
	}
	
	
	public int getMovieId() {
		return movieId;
	}
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getMovieType() {
		return movieType;
	}


	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}


	public String getMovieDescription() {
		return movieDescription;
	}


	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}


	public int getTicketPrice() {
		return ticketPrice;
	}


	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public char[][] getScreen() {
		return screen;
	}
	
	public String toString() {
		return movieName+"\t\t"+movieType+"\t\t"+movieDescription;
	}
	
}
