package com.example.h2database.service;


import com.example.h2database.ConnectQuestionBank;
import com.example.h2database.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	public List<ThemeCollection> getAllThemes() {
		Iterable<ThemeCollection> iter1 = themeRepository.findAll() ;
		return StreamSupport.stream(iter1.spliterator(),false).collect(Collectors.toList());
	}
	
	public List<ConnectQuestionBank> getAllDocuments() {
		Iterable<ConnectQuestionBank> iter2 = questionRepository.findAll();
		return StreamSupport.stream(iter2.spliterator(),false).collect(Collectors.toList()) ;
	}
}
