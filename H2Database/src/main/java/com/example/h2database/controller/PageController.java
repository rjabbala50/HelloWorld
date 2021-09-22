package com.example.h2database.controller;

import com.example.h2database.ConnectQuestionBank;
import com.example.h2database.DatabaseLoader;
import com.example.h2database.service.DatabaseReader;
import com.example.h2database.service.ThemeCollection;
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
	@GetMapping("/themes/")
	public List<ThemeCollection> readThemes() {
		return databaseReader.getAllThemes();
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/themes/collections")
	public List<ConnectQuestionBank> readCollection() {
		return databaseReader.getAllDocuments() ;
	}
	
	@Secured({"ROLE_ADMIN"})
	//@SetMapping(value="/add")
	@RequestMapping (value="/add")
	public void insertData() {
		databaseLoader.initDatabase();
	}
}
