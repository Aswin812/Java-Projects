package com.theatreApplication.screens.admin;

import java.util.List;

import com.theatreApplication.dataLayer.Repository;
import com.theatreApplication.dto.MovieDTO;
import com.theatreApplication.dto.TicketsDTO;

public class AdminViewModel {

	private Admin view;
	public AdminViewModel(Admin view) {
		this.view=view;
	}
	
	void addMovie(int id, String name, String type, String des, int price, char[][] screen) {
		Repository.getInstance().addMovie(id, name, type, des, price, screen);
	}
	
	void removeMovie(int id) {
		Repository.getInstance().removeMovie(id);
	}
	
	List<MovieDTO> getMovieList(){
		return Repository.getInstance().getMovies();
	}
	
	List<TicketsDTO> getTicktes(){
		return Repository.getInstance().getTickets();
	}
	
	char[][] getScreen(String movieName){
		return Repository.getInstance().getScreen(movieName);
	}
}
