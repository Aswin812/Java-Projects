package com.emailApplication.mails.user;

import com.emailApplication.mails.Input;
import com.emailApplication.mails.message.Mails;

public class User {

	public void userView(String email) {
		int inp=0;
		Mails mail=new Mails();
		do {
			System.out.println("\t1. Send Mail");
			System.out.println("\t2. Inbox");
			System.out.println("\t3. View Send Mail");
			System.out.println("\t4. View Draft Mail");// 5. Forward     6. Reply    
			System.out.println("\t5. Exit");
			
			inp=Input.getInstance().getInt();
			
			switch(inp) {
			case 1:
				mail.sendMail(email);
				break;
			case 2:
				mail.inbox(email);
				break;
			case 3:
				mail.viewSendMail(email);
				break;
			case 4:
				mail.viewDraftMail(email);
				break;
			case 5:
				System.out.println("Thank You...");
				break;
			default:
				System.out.println("Enter Valid Input");
			}
		}while(inp!=5);
	}
}

