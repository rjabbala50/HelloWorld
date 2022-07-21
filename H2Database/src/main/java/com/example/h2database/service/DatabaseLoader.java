package com.example.h2database.service;

import com.example.h2database.documents.ConnectQuestionBank;
import com.example.h2database.repository.QuestionRepository;
import com.example.h2database.documents.ThemeCollection;
import com.example.h2database.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.example.h2database.documents.ConnectQuestionBank.AnswerData ;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseLoader
 */
@Service
public class DatabaseLoader {
	private final QuestionRepository questionRepository ;
	private final ThemeRepository themeRepository;
	
	
	
	@Autowired
	public DatabaseLoader(QuestionRepository questionRepository, ThemeRepository themeRepository) {
		this.questionRepository = questionRepository;
		this.themeRepository = themeRepository ;
	}
	
	
	//@PostConstruct
	public void initDatabase () {
		insertQuestions();
		insertThemes();
	}
	
	private void insertThemes() {
		themeRepository.deleteAll();
		
		ThemeCollection themeCollection = new ThemeCollection() ;
		themeCollection.setThemeId(1);
		themeCollection.setThemeName("Manager");
		themeRepository.save(themeCollection) ;
		
		ThemeCollection themeCollection1 = new ThemeCollection() ;
		themeCollection1.setThemeId(2);
		themeCollection1.setThemeName("Team");
		themeRepository.save(themeCollection1) ;
		
		ThemeCollection themeCollection2 = new ThemeCollection() ;
		themeCollection2.setThemeId(3);
		themeCollection2.setThemeName("Career");
		themeRepository.save(themeCollection2) ;
	}
	
	
	private void insertQuestions() {
		questionRepository.deleteAll();
		
		ConnectQuestionBank cq = new ConnectQuestionBank();
		cq.setQuestion("Who is The Arunachala");
		cq.setQuestionId(1) ;
		cq.setThemeId(1);
		List<ConnectQuestionBank.AnswerData> ans = new ArrayList<>() ;
		ans.add(new ConnectQuestionBank.AnswerData(12,"First Answer Choice"))  ;
		ans.add(new ConnectQuestionBank.AnswerData(13,"Second Answer Choice"))  ;
		ans.add(new ConnectQuestionBank.AnswerData(14,"Third Answer Choice"))  ;
		ans.add(new ConnectQuestionBank.AnswerData(15,"Fourth Answer Choice"))  ;
		cq.setAnswerList(ans);
		questionRepository.save(cq);
		
		ConnectQuestionBank cq1 = new ConnectQuestionBank() ;
		cq1.setQuestion("The greatest teacher? Ramana Bhagavan. My Saviour, I love him");
		cq.setQuestionId(2) ;
		cq.setThemeId(2);
		List<ConnectQuestionBank.AnswerData> ans1 = new ArrayList<>() ;
		ans1.add(new ConnectQuestionBank.AnswerData(22,"First Answer Choice"))  ;
		ans1.add(new ConnectQuestionBank.AnswerData(23,"Second Answer Choice"))  ;
		ans1.add(new ConnectQuestionBank.AnswerData(24,"Third Answer Choice"))  ;
		ans1.add(new ConnectQuestionBank.AnswerData(25,"Fourth Answer Choice"))  ;
		cq1.setAnswerList(ans1);
		questionRepository.save(cq1) ;
		
		ConnectQuestionBank cq2 = new ConnectQuestionBank() ;
		cq2.setQuestion("Who is the mighty Vishnu, who is a tough CEO");
		cq.setQuestionId(3) ;
		cq.setThemeId(3);
		List<ConnectQuestionBank.AnswerData> ans2 = new ArrayList<>() ;
		ans2.add(new ConnectQuestionBank.AnswerData(32,"First Answer Choice"))  ;
		ans2.add(new ConnectQuestionBank.AnswerData(33,"Second Answer Choice"))  ;
		ans2.add(new ConnectQuestionBank.AnswerData(34,"Third Answer Choice"))  ;
		ans2.add(new ConnectQuestionBank.AnswerData(35,"Fourth Answer Choice"))  ;
		cq2.setAnswerList(ans2);
		questionRepository.save(cq2) ;
		
	}
}
