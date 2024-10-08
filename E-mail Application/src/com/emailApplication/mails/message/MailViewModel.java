package com.emailApplication.mails.message;

import java.util.List;

import com.emailApplication.dataLayer.Repository;
import com.emailApplication.dto.MessageDTO;

class MailViewModel {
	
	private Mails view;
	public MailViewModel(Mails view) {
		this.view=view;
	}
	
	void sendMail(String from, String to, String sub, String content) {
		Repository.getInstance().sendMails(from, to, sub, content);
	}
	
	void draftMail(String from, String to, String sub, String content) {
		Repository.getInstance().draftMails(from, to, sub, content);
	}
	
	boolean containsEmail(String email) {
		return Repository.getInstance().containsEmail(email);
	}
	
	List<MessageDTO> getInboxList(String email) {
		return Repository.getInstance().getInboxList(email);
	}
	
	List<MessageDTO> getSendMailList(String email) {
		return Repository.getInstance().getSendMailList(email);
	}
	
	List<MessageDTO> getDraftMailList(String email) {
		return Repository.getInstance().getDraftMailDTO(email);
	}

}
