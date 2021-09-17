package com.example1.service;

import org.springframework.stereotype.Service;


public class User {
	
	private String FirstName ;
	
	private String LastName ;
	
	public User( String fname, String lname) {
		this.FirstName=fname;
		this.LastName=lname ;
	}
	
	public String getFname()
	{
		return new String("FName:" +FirstName+"Lname"+LastName) ;
	}
	
	@Override
	public String toString() {
		return "User:"+"fname:"+FirstName+"lname"+LastName ;
	}
	
}
