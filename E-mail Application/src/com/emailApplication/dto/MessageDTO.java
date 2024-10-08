package com.emailApplication.dto;


public class MessageDTO {

//	private String fromEmail;
	private String toEmail;
	private String subject;
	private String content;
	
	
	
	
	public MessageDTO(String toEmail, String sub, String content) {
//		this.fromEmail=fromEmail;
		this.toEmail=toEmail;
		this.subject=sub;
		this.content=content;
	}
	
	
//	public String getFromEmail() {
//		return fromEmail;
//	}

	public String getToEmail() {
		return toEmail;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}
	
	public String toString() {
		return "To : "+toEmail+"\nSubject : "+subject+"\nContent: "+content+"\n";
	}
}
