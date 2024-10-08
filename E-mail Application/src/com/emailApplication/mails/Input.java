package com.emailApplication.mails;

import java.util.Scanner;
public class Input {

	Scanner s=new Scanner(System.in);
	
	private static Input input;
	public static Input getInstance() {
		if(input==null)
			input=new Input();
		return input;
	}
	
	public int getInt() {
		int num=0;
		while(true) {
			if(s.hasNextInt()) {
				num=s.nextInt();
				break;
			}
			else {
				System.out.println("Enter Valid Input !");
				s.nextLine();
			}
		}
		s.nextLine();
		return num;
	}
	
	public String getString() {
		String str=s.nextLine();
		return str;
	}
}
