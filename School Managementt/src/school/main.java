package school;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		details obj=new details(); 
		int num=0;

		do {
			System.out.println("Enter your Choise");
			System.out.println();
			System.out.println("\t 1. Add Student Details");
			System.out.println("\t 2. View Student Details");
			System.out.println("\t 3. Update Student Details");
			System.out.println("\t 4. Remove Student Details");
			System.out.println("\t 5. Exit");
		
		num=s.nextInt();
		switch(num) {
		case 1:
			obj.getDetails();
			break;
			
		case 2:
			obj.viewDetails();
			break;
			
		case 3:
			obj.Update();
			break;
		
		case 4:
			obj.Remove();
			break;
			
		case 5:
			System.out.println("Thank You...");
			break;
			
		default :
			System.out.println("Enter Valid Number");
			 
		}
		}while(num!=5);
		
	}

}
