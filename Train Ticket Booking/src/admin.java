import java.util.Scanner;

public class admin {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		tickets obj=new tickets();
		int num=0;
		do {
			System.out.println("Enter your Choice");
			System.out.println();
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. Print booked ticket");
			System.out.println("4. Print Available Ticket");
			System.out.println("5. Exit");
			
			num=s.nextInt();
			
			switch(num) {
			case 1:
					obj.book();
					break;
				
			case 2:
				obj.cancel();
				break;
				
			case 3:
				obj.bookedTicket();
				break;
				
			case 4:
				obj.availableTicket();
				break;
				
			}
				
		}while(num!=5);
	}

}
