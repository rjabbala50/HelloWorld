package com.example.h2database.controller;

import com.example.h2database.service.bulkWriteThemes;
import com.example.h2database.documents.ConnectQuestionBank;
import com.example.h2database.service.DatabaseLoader;
import com.example.h2database.service.DatabaseReader;
import com.example.h2database.documents.ThemeCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.h2database.service.bulkWriteThemes;


@RestController
public class PageController {
	
	@Autowired
	private DatabaseReader databaseReader ;
	
	@Autowired
	private DatabaseLoader databaseLoader;
	
	@Autowired
	protected bulkWriteThemes bulkWriteThemes ;
	
	//@Secured(value = {"ROLE_USER"})
	@RequestMapping(value = "/")
	public String getDocuments() {
		return "Welcome to Employee Connections";
	}
	
	//@Secured(value = {"ROLE_ADMIN","ROLE_USER"})
	@GetMapping(value = "/themes")
	public List<ThemeCollection> readThemes()  {
	System.out.println("Inside readThemes") ;
		databaseLoader.initDatabase() ;
		return databaseReader.getAllThemes();
	}
	
	//@Secured(value = {"ROLE_ADMIN","ROLE_USER"})
	@GetMapping(value = "/themes/collections")
	public List<ConnectQuestionBank> readCollection() {
		databaseLoader.initDatabase() ;
		return databaseReader.getAllDocuments();
	}
	
	@GetMapping(value="/themes/bulk")
	//public List<ThemeCollection> insertBulk() {
	public Long insertBulk() {
		
		bulkWriteThemes.insertBulkThemes() ;
		//return databaseReader.getAllThemes() ;
		return databaseReader.getDocumentCountFromCollection();
	}
	
	
	//@Secured(value = {"ROLE_ADMIN","ROLE_USER"})
	//@RequestMapping (value="/add")
	@PostMapping(value = "value=/add")
	public void insertData() {
		databaseLoader.initDatabase();
	}
	
	
	
	/*
	@RequestMapping(value = "/error")
	public String displayErrorPage ()  {
		return "Oooooops sorry Page not found" ;
	}
	*/
}
