package com.example.h2database.controller;

import com.example.h2database.ConnectQuestionBank;
import com.example.h2database.DatabaseLoader;
import com.example.h2database.service.DatabaseReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PageController {
	
	@Autowired
	DatabaseReader databaseReader ;
	
	@Autowired
	DatabaseLoader databaseLoader ;
	
	@Secured({"ROLE_USER"})
	@RequestMapping("/")
	public String getDocuments() {
		return "Welcome to Employee Connections" ;
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/id")
	public List<String> returnCollection() {
		return databaseReader.getAllDocuments() ;
	}
/*
	@RequestMapping(value="/add")
	//@PostMapping(value="/add")
	public   ConnectQuestionBank createQuestion(@RequestBody ConnectQuestionBank connectQuestionBank) {
		return databaseLoader.addQuestion(connectQuestionBank) ;
	
	}
	
 */
}
