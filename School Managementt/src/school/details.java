package school;
import java.util.HashMap;
import java.util.Scanner;
public class details {
	
	static Scanner s=new Scanner(System.in);
//	public static ArrayList<studentDetails> list=new ArrayList<>();
	HashMap<Integer,studentDetails> m=new HashMap<>();
	static int id=101;
	public void getDetails() {
		System.out.println("Enter Student Name : ");
		String name=s.nextLine();
		
		System.out.println("Enter Roll NO : ");
		int rollNum=s.nextInt();
		
		System.out.println("Enter Std : ");
		int std=s.nextInt();
		
		System.out.println("Enter Student Age : ");
		int age=s.nextInt();
		s.nextLine();
		System.out.println("Enter Phone Number : ");
		String phoneNumber=s.nextLine();
		studentDetails val=new studentDetails(name,id,rollNum,std,age,phoneNumber);
		m.put(id,val);
		System.out.println("Successfully Added...");
		id++;
	}
	public void viewDetails() {
		if(m.size()==0) {
			System.out.println("Students not Registered");
		}
		else {
			System.out.println("Enter Student Id : ");
			int studentId=s.nextInt();
			System.out.println("Name\tStudentId\tRollNum\tStd\tAge\tPhoneNumber");
			if(m.containsKey(studentId)) {
				System.out.println(m.get(studentId).getName()+"\t"+m.get(studentId).getId()+"\t\t"+m.get(studentId).getRollNum()+"\t"+m.get(studentId).getStd()+"\t"+m.get(studentId).getAge()+"\t"+m.get(studentId).getPhoneNumber());
			}
			else {
				System.out.println("Enter Correct ID Number...");
			}
			
		
		}
	}
	public void Update() {
		int studentId=0;
		if(m.size()==0) {
			System.out.println("Students not Registered");
		}
		else {
			System.out.println("Enter Student Id : ");
			studentId=s.nextInt();
			s.nextLine();  
		}
		 if(m.containsKey(studentId)) {
			 System.out.println("Enter Your Choice");
			 System.out.println();
			 System.out.println("1. Change Student Name : ");
			 System.out.println("2. Change Roll NO : ");
			 System.out.println("3. Change Std : ");
			 System.out.println("4. Change Student Age : ");
			 System.out.println("5. Change Phone Number : ");
			 
			 int num=s.nextInt();
			 s.nextLine();
			 switch(num) {
			 case 1:
				 System.out.println("Enter Student Name : ");
				 m.get(studentId).setName(s.nextLine());
				 break;
				 
			 case 2:
				 System.out.println("Enter Roll NO : ");
				 m.get(studentId).setRollNum(s.nextInt());
				 break;
				 
			 case 3:
				 System.out.println("Enter Std : ");
				 m.get(studentId).setStd(s.nextInt());
				 break;
				 
			 case 4:
				 System.out.println("Enter Student Age : ");
				 m.get(studentId).setAge(s.nextInt());
				 s.nextLine();
				 break;
				 
				 
			 case 5:
				 System.out.println("Enter Phone Number : ");
				 m.get(studentId).setPhoneNumber(s.nextLine()); 
				 break;
			 }
				 
			System.out.println("Successfully Changed...");				 
		}
		else {
			System.out.println("Enter Correct Student Id...");
		}
	}
	public void Remove() {
		System.out.println("Enter Student Id : ");
		int studentId=s.nextInt();
		if(m.size()==0) {
			System.out.println("Studens not Registered");
		}
		else if(m.containsKey(studentId)) {
			m.remove(studentId);
			System.out.println("Successfully Removed");
		}
		else {
			System.out.println("Student Id not Match...");
		}
	}
	
}
