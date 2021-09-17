package com.example.h2database;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DatabaseLoader {
	private final QuestionRepository questionRepository ;
	
	@Autowired
	public DatabaseLoader(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	@PostConstruct
	private void initDatabase () {
		questionRepository.deleteAll();
		ConnectQuestionBank cq = new ConnectQuestionBank();
		cq.setQuestion("Who is The Arunachala");
		questionRepository.save(cq);
		
		ConnectQuestionBank cq1 = new ConnectQuestionBank() ;
		cq1.setQuestion("The greatest teacher? Ramana Bhagavan. My Saviour, I love him");
		questionRepository.save(cq1) ;
		
		ConnectQuestionBank cq2 = new ConnectQuestionBank() ;
		cq2.setQuestion("Who is the mighty Vishnu, who is a tough CEO");
		questionRepository.save(cq2) ;
	}
}
