package com.library.screens.admin;

import java.util.List;
import java.util.Map;

import com.library.dto.BookDTO;
import com.library.dto.TransactionsDTO;
import com.library.dto.UserDTO;
import com.library.screens.Input;

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
			System.out.println("\t 1. Add Book");
			System.out.println("\t 2. Remove Book");
			System.out.println("\t 3. Remove Member");
			System.out.println("\t 4. View Book List");
			System.out.println("\t 5. View Member List");
			System.out.println("\t 6. View Borrowed Books");
			System.out.println("\t 7. View Transaction History");
			System.out.println("\t 8. Exit");
			
			inp=Input.getInstance().getInt();
			
			switch(inp) {
			case 1:
				addBook();
				break;
			case 2:
				removeBook();
				break;
			case 3:
				removeUser();
				break;
			case 4:
				viewBookList();
				break;
			case 5:
				viewUserList();
				break;
			case 6:
				viewBorrowedBooks();
				break;
			case 7:
				viewTransactionHistory();
				break;
			case 8:
				System.out.println("Thank You");
				break;
			default :
				System.out.println("Enter Valid Input");
			}
		}while(inp!=8);
	}
	
	
	private void addBook() {
		System.out.println("Enter Book Title : ");
		String title=Input.getInstance().getString();
		System.out.println("Enter ISBN Number : ");
		String isbn=Input.getInstance().getString();
		System.out.println("Enter Author Name : ");
		String author=Input.getInstance().getString();
		System.out.println("Enter price : ");
		int price=Input.getInstance().getInt();
		
		viewModel.addBook(title, isbn, author, price); 
		System.out.println("Book added Successfully...");

	}
	
	
	private void removeBook() {
		System.out.println("Enter Book Title : ");
		String title=Input.getInstance().getString();
		if(viewModel.removeBook(title)) {
			System.out.println("Book Remove Successfully");
		}
		else {
			System.out.println("Enter Valid ISBN Number");
		}
	}
	
	public void viewBookList() {
		List<BookDTO> books=viewModel.getBookList();
		
		if(books.isEmpty()) {
			System.out.println("Book List is Empty...");
			return ;
		}
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Book Title\t Book ISBN\t Author Name\t Book Price");
		System.out.println("---------------------------------------------------------------------------------------------");
		for(BookDTO book: books) {
			System.out.println(book.getTitle()+"\t "+book.getIsbn()+"\t "+book.getAuthor()+"\t\t "+book.getPrice());
		}
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	
	private void removeUser() {
		System.out.println("Enter Member Id : ");
		int id=Input.getInstance().getInt();
		if(viewModel.removeUser(id)) {
			System.out.println("User Removed Successfully");
		}
		else {
			System.out.println("Enter Valid User Id...");
		}
	}
	
	
	private void viewUserList() {
		List<UserDTO> accounts=viewModel.getUserList();
		if(accounts.isEmpty()) {
			System.out.println("Member List is Empty...");
			return;
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Member Name\t Member Id\t Mobile Number");
		System.out.println("-----------------------------------------------------------------------------------");
		for(UserDTO user: accounts) {
			System.out.println(user.getUserName()+"\t\t"+user.getUserId()+"\t\t"+user.getMobileNumber());
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}
	
	private void viewBorrowedBooks() {
		Map<String, List<BookDTO>> borrowBooks=viewModel.getBorrowedBooks();
		if(borrowBooks.isEmpty()) {
			System.out.println("Borrow Book List is Empty");
		}
		else {
			for(String userName: borrowBooks.keySet()) {
				System.out.println(userName +" : ");
				List<BookDTO> list=borrowBooks.get(userName);
				for(BookDTO book: list) {
					System.out.println("\t"+book.getTitle()+"\t "+book.getIsbn()+"\t "+book.getAuthor()+"\t\t "+book.getPrice());
				}
			}
		}
	}
	
	private void viewTransactionHistory() {
		List<TransactionsDTO> transactions=viewModel.getTransactionHistory();

		if(transactions.isEmpty()) {
			System.out.println("Transactions History is Empty...");
			return;
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("User Name\t Book Title\t Borrow Or Return");
		System.out.println("-----------------------------------------------------------------------------------");
		for(TransactionsDTO user: transactions) {
			System.out.println(user.getUserName()+"\t\t"+user.getBookTitle()+"\t\t"+user.getBorrowOrReturn());
		}
		System.out.println("-----------------------------------------------------------------------------------");
		
	}
	
	
}
