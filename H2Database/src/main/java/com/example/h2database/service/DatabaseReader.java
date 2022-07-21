package com.example.h2database.service;

import com.example.h2database.documents.ConnectQuestionBank;
import com.example.h2database.documents.ThemeCollection;
import com.example.h2database.repository.QuestionRepository;
import com.example.h2database.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DatabaseReader {
	
	private final QuestionRepository questionRepository ;
	private final ThemeRepository themeRepository ;
	
	
	@Autowired
	public DatabaseReader(QuestionRepository questionRepository, ThemeRepository themeRepository) {
		this.questionRepository = questionRepository ;
		this.themeRepository = themeRepository ;
	}
	
	
	//@PostConstruct
	public List<ThemeCollection> getAllThemes() {
		Iterable<ThemeCollection> iter1 = themeRepository.findAll() ;
		System.out.println("Print Iter+   "+iter1) ;
		return StreamSupport.stream(iter1.spliterator(),false).collect(Collectors.toList());
	}
	
	//@PostConstruct
	public List<ConnectQuestionBank> getAllDocuments() {
		Iterable<ConnectQuestionBank> iter2 = questionRepository.findAll();
		return StreamSupport.stream(iter2.spliterator(),false).collect(Collectors.toList()) ;
	}
	
	//Get count of documents in collection
	public Long getDocumentCountFromCollection() {
		return themeRepository.count() ;
	}
}
