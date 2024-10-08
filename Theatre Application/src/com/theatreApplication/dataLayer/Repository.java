package com.theatreApplication.dataLayer;

import java.util.ArrayList;
import java.util.List;

import com.theatreApplication.dto.MovieDTO;
import com.theatreApplication.dto.TicketsDTO;
import com.theatreApplication.dto.UserDTO;

public class Repository {
	
	private static Repository repository;
	public static Repository getInstance() {
		if(repository==null)
			repository=new Repository();
		return repository;
	}
	
	List<UserDTO> accounts=new ArrayList<>();
	List<MovieDTO> movies=new ArrayList<>();
	List<TicketsDTO> tickets=new ArrayList<>();
	
	
	
	
	public void createAccount(String name, String email, String password, String dob, String number) {
		accounts.add(new UserDTO(name, email, password, dob, number));
	}
	
	public void addMovie(int id, String name, String type, String des, int price, char[][] screen) {
		movies.add(new MovieDTO(id, name, type, des, price, screen));
	}
	
	public void removeMovie(int id) {
		for(MovieDTO movie: movies) {
			if(movie.getMovieId()==id) {
				movies.remove(movie);
				return ;
			}
		}
	}
	
	public List<MovieDTO> getMovies(){
		return movies;
	}
	
	public List<TicketsDTO> getTickets() {
		return tickets;
	}
	
	public boolean verifyEmail(String email, String password) {
		for(UserDTO user: accounts) {
			if(user.getEmail().equals(email)&&user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsMovie(String movieName) {
		for(MovieDTO movie : movies) {
			if(movie.getMovieName().equals(movieName)) return true;
		}
		return false;
	}
	
	public char[][] getScreen(String movieName){
		for(MovieDTO movie : movies) {
			if(movie.getMovieName().equals(movieName)) {
				return movie.getScreen();
			}
		}
		return new char[10][15];
	}
	
	public void bookTicket(String email, String movieName, String seatNum, int row, int col) {
		for(MovieDTO movie: movies) {
			if(movie.getMovieName().equals(movieName)) {
				movie.getScreen()[row][col]='X';
				break;
			}
		}
		tickets.add(new TicketsDTO(email, movieName, seatNum));
	}
	
	public boolean isValidSeat(String movieName, String seatNum) {
		int row=seatNum.charAt(0)-'A';
		int col=Integer.parseInt(seatNum.substring(1, seatNum.length()));
		for(MovieDTO movie : movies) {
			if(movie.getMovieName().equals(movieName) && movie.getScreen()[row][col]!='X') {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkUserHaveTicket(String email) {
		for(TicketsDTO ticket : tickets) {
			if(ticket.getUserEmail().equals(email)) return true;
		}
		return false;
	}
	
	public void cancelTicket(String email, String movieName, String seatNum, int row, int col) {
		for(TicketsDTO ticket : tickets) {
			if(ticket.getUserEmail().equals(email) && ticket.getMovieName().equals(movieName)&&ticket.getSeatNum().equals(seatNum)) {
				tickets.remove(ticket); 
				break;
			}
		}
		
		for(MovieDTO movie : movies) {
			if(movie.getMovieName().equals(movieName)) {
				movie.getScreen()[row][col]='.';
				break;
			}
		}
		
	}
	
	
}
