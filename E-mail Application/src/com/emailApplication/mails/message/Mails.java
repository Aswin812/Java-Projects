package com.emailApplication.mails.message;

import java.util.List;

import com.emailApplication.dto.MessageDTO;
import com.emailApplication.mails.Input;

public class Mails {
	int count=0;
	
	private MailViewModel viewModel;
	public Mails() {
		viewModel=new MailViewModel(this);
	}
	

	public void sendMail(String email) {
		count++;
		if(count==4) {
			count=0;
			return;
		}
		String toMail="";
		do {
			System.out.println("From : "+email);
			System.out.print("To : ");
			toMail=Input.getInstance().getString();
			
			if(viewModel.containsEmail(toMail))
				break;
			else 
				System.out.println("This Email not Exist...");
		}while(true);
		
		System.out.print("Subject : ");
		String sub=Input.getInstance().getString();
		System.out.print("Content : ");
		String content=Input.getInstance().getString();
		
		int inp=0;
		
		do {
			System.out.println("1. Send Mail  (or)  2. Draft");
			inp=Input.getInstance().getInt();
			
			switch(inp) {
			case 1:
				viewModel.sendMail(email, toMail, sub, content); 
				break;
			case 2:
				viewModel.draftMail(email, toMail, sub, content); 
				break;
			default :
				System.out.println("Enter Valid Input");
			}
		}while(inp!=1&&inp!=2);
		
		
	}
	
	public void inbox(String email) {
		List<MessageDTO> list=viewModel.getInboxList(email);
		
		if(list.isEmpty()) {
			System.out.println();
			System.out.println("Inbox List is Empty...");
			System.out.println();
		}
		else {
			System.out.println();
			for(MessageDTO msg: list) {
				System.out.println("From : "+msg.getToEmail());
				System.out.println("To : "+email);
				System.out.println("Subject : "+msg.getSubject());
				System.out.println("Content : "+msg.getContent());
			}
			System.out.println();
		}
	}
	
	public void viewSendMail(String email) {
		List<MessageDTO> list=viewModel.getSendMailList(email);
		
		if(list.isEmpty()) {
			System.out.println();
			System.out.println("Send Mail List is Empty...");
			System.out.println();
		}
		else {
			System.out.println();
			for(MessageDTO msg: list) {
				System.out.println("From : "+email);
				System.out.println(msg.toString());
			}
			System.out.println();
		}
	}

	public void viewDraftMail(String email) {
		List<MessageDTO> list=viewModel.getDraftMailList(email);
		
		if(list.isEmpty()) {
			System.out.println();
			System.out.println("Draft Mail List is Empty...");
			System.out.println();
		}
		else {
			System.out.println();
			for(MessageDTO msg: list) {
				System.out.println("From : "+email);
				System.out.println(msg.toString());
			}
			System.out.println();
		}
	}
	
}

