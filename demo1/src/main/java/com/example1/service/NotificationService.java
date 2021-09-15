package com.example1.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	@Value("${NotificationService.notification}")
	public String notification  ;
	
	public NotificationService() {
	
	}
	
	public String noteIt() {
		
		return notification ;
		
	}
}
