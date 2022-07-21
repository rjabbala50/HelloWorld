package com.example.h2database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


//@EnableMongoRepositories
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages= "com.example.h2database")
@SpringBootApplication
public class H2DatabaseApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(H2DatabaseApplication.class) ;
	
	public static void main(String[] args) {
		SpringApplication.run(H2DatabaseApplication.class, args);
		logger.info("Application Class Started");
	}
}
