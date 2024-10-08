package com.theatreApplication.screens.admin;

import java.util.List;

import com.theatreApplication.dto.MovieDTO;
import com.theatreApplication.dto.TicketsDTO;
import com.theatreApplication.screens.Input;

public class Admin {
	
	private AdminViewModel viewModel;
	public Admin() {
		viewModel=new AdminViewModel(this);
	}
	
	private static Admin admin;
	public static Admin getInstance() {
		if(admin==null)
			admin=new Admin();
		return admin;
	}
	
	
	public void adminWorks() {
		int inp=0;
		do {
			System.out.println("\t 1. Add Movie");
			System.out.println("\t 2. Remove Movie");
			System.out.println("\t 3. View Movie List");
			System.out.println("\t 4. View Seats");
			System.out.println("\t 5. View Tickets");
			System.out.println("\t 6. Exit");

			inp=Input.getInstance().getInt();
			
			switch(inp) {
			case 1:
				addMovie();
				break;
			case 2:
				removeMovie();
				break;
			case 3:
				viewMovieList();
				break;
			case 4:
				System.out.println("Enter Movie Name : ");
				String movieName=Input.getInstance().getString();
				viewSeats(movieName);
				break;
			case 5:
				viewTickets();
			case 6:
				System.out.println("Thank You...");
				break;
			default:
				System.out.println("Enter Valid Input");
			}
		}while(inp!=6);
		
	}
	
	
	private void addMovie() {
		System.out.println("Enter Movie Id : ");
		int id=Input.getInstance().getInt();
		System.out.println("Enter Movie Name : ");
		String name=Input.getInstance().getString();
		System.out.println("Enter Movie Type : ");
		String type=Input.getInstance().getString();
		System.out.println("Enter Movie Description : ");
		String description=Input.getInstance().getString();
		System.out.println("Enter Ticket Price : ");
		int ticketPrice=Input.getInstance().getInt();
		
		char[][] screen=new char[10][15];
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<15; j++) {
				screen[i][j]='.';
			}
		}
		
		viewModel.addMovie(id, name, type, description, ticketPrice, screen);

	}
	
	private void removeMovie() {
		System.out.println("Enter Movie Id : ");
		int id=Input.getInstance().getInt();
		viewModel.removeMovie(id);
		System.out.println("Movie Removed Successfully...");
	}
	
	public void viewMovieList() {
		List<MovieDTO> movies=viewModel.getMovieList();
		if(movies.isEmpty()) {
			System.out.println("Movie List is Empty ! ");
			return ;
		}
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Movie Name\t Movie Type\t Movie Description");
		System.out.println("-----------------------------------------------------------------");
		for(MovieDTO movie: movies) {
			System.out.println(movie.toString());
		}
		System.out.println("-----------------------------------------------------------------");
			
		
	}
	
	public void viewSeats(String movieName) {
		char[][] screen=viewModel.getScreen(movieName);
		char row='A';
		System.out.println("   1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
		System.out.println();
		for(int i=0; i<10; i++) {
			System.out.print(row+++"  ");
			for(int j=0; j<15; j++) {
				System.out.print(screen[i][j]+" |");
			}
			System.out.println();
		}
	}
	
	
	private void viewTickets() {
		List<TicketsDTO> tickets=viewModel.getTicktes();
		
		if(tickets.isEmpty()) {
			System.out.println("Ticket List is Empty...");
			return;
		}
		System.out.println("Movie Name\t\t User Email\t Seat Number");
		for(TicketsDTO ticket : tickets) {
			System.out.println(ticket.getMovieName()+"\t\t"+ticket.getUserEmail()+"\t\t"+ticket.getSeatNum());
		}
	}
	
	
}
