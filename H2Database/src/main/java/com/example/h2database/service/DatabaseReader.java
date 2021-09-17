package com.example.h2database.service;


import com.example.h2database.ConnectQuestionBank;
import com.example.h2database.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DatabaseReader {
	
	@Autowired
	private QuestionRepository questionRepository ;
	
	public DatabaseReader() {
	}
	
	public List<String> getAllDocuments() {
		Iterable<ConnectQuestionBank> iter = questionRepository.findAll();
		
		List<String> documents = new ArrayList<>() ;
		
		for (ConnectQuestionBank qs:iter) {
			documents.add(qs.getQuestion()) ;
		}
		return documents ;
	}
}
