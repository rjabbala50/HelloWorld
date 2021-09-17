package com.example.h2database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class H2DatabaseApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(H2DatabaseApplication.class) ;
	
	public static void main(String[] args) {
		SpringApplication.run(H2DatabaseApplication.class, args);
		logger.info("Documents in MongoDB inserted");
	}
}
