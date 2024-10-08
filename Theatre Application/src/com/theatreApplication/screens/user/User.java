package com.theatreApplication.screens.user;

import com.theatreApplication.screens.Input;
import com.theatreApplication.screens.admin.Admin;

public class User {
	
	private UserViewModel viewModel;
	public User() {
		viewModel=new UserViewModel(this);
	}
	
	public void userPage(String email) {
		int inp=0;
		
		do {
			
			System.out.println("1. Book Movie");
			System.out.println("2. Cancel Movie");
			System.out.println("3. Exit");
			
			inp=Input.getInstance().getInt();
			switch(inp) {
			case 1:
				bookTicket(email);
				break;
			case 2:
				cancelTicket(email);
				break;
			case 3:
				System.out.println("Thank You...");
				break;
			default :
				System.out.println("Enter Valid Input");
			}
			
		}while(inp!=3);
	}
	
	private void bookTicket(String email) {
		Admin.getInstance().viewMovieList();
		System.out.println("Enter Movie Name : ");
		String movieName=Input.getInstance().getString();
		if(!viewModel.containsMovie(movieName)) {
			System.out.println("This Movie not available");
			bookTicket(email);
			return ;
		}
		String seatNum="";
		
		do {
			Admin.getInstance().viewSeats(movieName);
			System.out.println("Enter Seat Row :  ->(A3)");
			seatNum=Input.getInstance().getString();
			if(!viewModel.validSeatNum(seatNum)) {
				System.out.println("Enter Valid Input");
				continue;
			}
			if(!viewModel.isValidSeat(movieName, seatNum)) {
				System.out.println("This seat Already Booked !");
				System.out.println("Select Other Seat");
				continue;
			}
			break;
			
		}while(true);
		
		
		viewModel.bookTicket(email, movieName, seatNum);
		System.out.println();
		System.out.println("Ticket Booked Successfully...");
		System.out.println();
		
		int inp=0;
		do {
			System.out.println("1. Continue Booking  (or)  2. Close");
			inp=Input.getInstance().getInt();
			if(inp==1) bookTicket(email);
			switch(inp) {
			case 1:
				bookTicket(email);
				break;
			case 2:
				System.out.println("Thank You...");
				break;
			default :
				System.out.println("Enter Valid Input");
			}
			
		}while(inp!=2);
		
		
	}
	
	private void cancelTicket(String email) {
		if(viewModel.checkUserHaveTicket(email)) {
			System.out.println("You Don't Have Tickets !");
			return ;
		}
		
		System.out.println("Enter Movie Name : ");
		String movieName=Input.getInstance().getString();
		if(!viewModel.containsMovie(movieName)) {
			System.out.println("This Movie not available");
			cancelTicket(email);
		}
		String seatNum="";
		
		do {
			System.out.println("Enter Seat Row :  ->(A3)");
			seatNum=Input.getInstance().getString();
			if(!viewModel.validSeatNum(seatNum)) {
				System.out.println("Enter Valid Input");
				continue;
			}
			if(!viewModel.isValidSeat(movieName, seatNum)) {
				viewModel.cancelTicket(email, movieName, seatNum); 
				System.out.println();
				System.out.println("Ticket Canceled Successfully...");
				System.out.println();
				return;
			}
			break;
			
		}while(true);
		System.out.println();
		System.out.println("This Seat is Not Booked for You");
		System.out.println();
		
		
	}
	
}
