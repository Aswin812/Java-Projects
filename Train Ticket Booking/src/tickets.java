import java.util.HashMap;
import java.util.Scanner;
 
public class tickets {
	HashMap<Integer,management> bookedTicket=new HashMap<>();
	HashMap<Integer,management> RAC=new HashMap<>();
	HashMap<Integer,management> waitingList=new HashMap<>();
	Scanner s=new Scanner(System.in);
	int totalTicket=12;
	int confirmedTicket=0;
	int rac=0;
	int waiting=0;
	int id=1;
	int lo=0,mid=0,up=0;
	boolean flag1=true,flag2=true;
	public void book() {
		System.out.println("Enter Name : ");
		String name=s.nextLine();
		System.out.println("Enter Age : ");
		int age=s.nextInt();
		String gender="";
		int g=0;
		do {
			System.out.println("Gender : ");
			System.out.println("1. male\t\t2. female");
			g=s.nextInt();
			switch(g) {
			case 1:
				gender="male";
				break;
			case 2:
				gender="female";
				break;
			default:
				System.out.println("Enter valid number");
			}
		}while(g!=1 && g!=2);
		
		int b=0;
		String berth="";
		do {
			System.out.println("Berth Preference");
			System.out.println("1. Upper\t\t 2.middle\t\t 3.Lower");
			b=s.nextInt();
			switch(b) {
			case 1:
				if(up>=totalTicket/3) {
					System.out.println("Upper berth not available");
				}else {					
					berth="Upper";
					up++;
					confirmedTicket+=1;
					System.out.println("Ticket Booked in Upper Berth");
					break;
				}
				
			case 2:
				if(mid>=totalTicket/3) {
					System.out.println("Middle berth not available");
				}
				else {
					
					berth="Middle";
					mid++;
					confirmedTicket+=1;
					System.out.println("Ticket Booked in Middle Berth");
					break;
				}
			
			case 3:
				if(lo<(totalTicket-(totalTicket/3)*2)) {
					berth="Lower";
					lo++;
					confirmedTicket+=1;
					System.out.println("Ticket Booked in Lower Berth");
					break;										
				}
				else if(rac<5) {
					flag1=false;
					rac++;
					System.out.println("Ticket Booked in RAC");
					break;
				}
				else if(waiting<5) {
					flag1=false;
					flag2=false;
					waiting++;
					System.out.println("Ticket Booked in Waiting List");
					break;
				}
				else {
					System.out.println("Ticket not available");
					break;
				}
			
			default:
				System.out.println("Enter Valid  Number");
				
			}
		}while(b!=1 && b!=2 && b!=3);
		s.nextLine();
		
		management detail=new management(name,id,age,gender,berth);
		if(flag1 && flag2)bookedTicket.put(id, detail);
		else if(flag1 || flag2)RAC.put(id, detail);
		else waitingList.put(id,detail);

        id++;
		}
	public void cancel() {
		if(bookedTicket.size()==0) {
			System.out.println("Ticket not Booked");
		}
		else {
			System.out.println("Enter Id : ");
			int id=s.nextInt();
			if(bookedTicket.containsKey(id)) {
				String check=bookedTicket.get(id).getBerth();
				if(check.equals("Upper"))up--;
				else if(check.equals("Middle"))mid--;
				else if(check.equals("Lower"))lo--;
				bookedTicket.remove(id);
				confirmedTicket-=1;
				System.out.println("Successfully Removed");
			}
			else {
				System.out.println("Id incorrect");
			}
		}
		s.nextLine();
	}
	public void bookedTicket() {
		System.out.println("Total Booked Ticket = "+confirmedTicket);
		System.out.println("Upper = "+up);
		System.out.println("Middle = "+mid);
		System.out.println("Lower = "+lo);
	}
	public void availableTicket() {
		System.out.println("Total Available Ticket = "+(totalTicket-confirmedTicket));
		System.out.println("Upper Berth = "+((totalTicket/3)-up));
		System.out.println("Middle Berth = "+((totalTicket/3)-mid));
		System.out.println("Lower Berth = "+((totalTicket-(totalTicket/3)*2)-lo));
	}
}
