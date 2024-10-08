package com.emailApplication.dataLayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emailApplication.dto.AccountsDTO;
import com.emailApplication.dto.MessageDTO;

public class Repository {
	
	private static Repository repository;
	public static Repository getInstance() {
		if(repository==null)
			repository=new Repository();
		return repository;
	}
	
	public Map<String, AccountsDTO> accounts =new HashMap<>();
	public Map<String , List<MessageDTO>> inbox=new HashMap<>();
	public Map<String , List<MessageDTO>> sendMails=new HashMap<>();
	public Map<String , List<MessageDTO>> draftMails=new HashMap<>();
	
	public void createAccount(String name, String email, String password, int age, String gender) {
		accounts.put(email, new AccountsDTO(name, password, age, gender));
	}
	
	public boolean emailVerification(String email, String password) {
		if(accounts.containsKey(email)&&accounts.get(email).getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	
	public boolean containsEmail(String email) {
		if(accounts.containsKey(email)) {
			return true;
		}
		return false;
	}
	
	public void sendMails(String from, String to, String sub, String content) {
		List<MessageDTO> send = sendMails.getOrDefault(from, new ArrayList<>());
		send.add(new MessageDTO(to, sub, content));
		sendMails.put(from, send);
		List<MessageDTO> list=inbox.getOrDefault(to, new ArrayList<>());
		list.add(new MessageDTO(from, sub, content));
		inbox.put(to, list);
	}
	
	public void draftMails(String from, String to, String sub, String content) {
		List<MessageDTO> list = draftMails.getOrDefault(from, new ArrayList<>());
		list.add(new MessageDTO(to, sub, content));
		draftMails.put(from, list);
	}
	
	
	public List<MessageDTO> getInboxList(String email){
		if(inbox.containsKey(email)) {
			return inbox.get(email);
		}
		return new ArrayList<MessageDTO>();
	}
	
	public List<MessageDTO> getSendMailList(String email){
		if(sendMails.containsKey(email)) {
			return inbox.get(email);
		}
		return new ArrayList<MessageDTO>();
	}
	
	public List<MessageDTO> getDraftMailDTO(String email){
		if(draftMails.containsKey(email)) {
			return inbox.get(email);
		}
		return new ArrayList<MessageDTO>();
	}
	
	
	
	
	
}
