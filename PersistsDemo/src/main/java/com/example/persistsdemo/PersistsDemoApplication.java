package com.example.persistsdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;


@SpringBootApplication
@ComponentScan(basePackages={"com.example.persistsdemo","com.example.repository"})

public class PersistsDemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(PersistsDemoApplication.class);
	
	
	@Autowired
	PostsRepository postsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PersistsDemoApplication.class, args);
		
	}
	
	@PostConstruct
	void setPosts()
	{
		logger.info("Inside logger main");
		//postsRepository.save(new Posts((long)9,"Arunachala")) ;
		//postsRepository.save(new Posts((long)8,"Ramana")) ;
		for (Posts p : postsRepository.findAll()) {
			//System.out.println("  :\n: "+ p.toString());
			logger.info(p.toString());
		}
	}
}
