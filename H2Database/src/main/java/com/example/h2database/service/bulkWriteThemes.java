package com.example.h2database.service;


import com.example.h2database.documents.ThemeCollection;
import com.example.h2database.repository.ThemeRepository;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class bulkWriteThemes {
	
	private static long recordCount = 0;
	private static long maxRecords = 0;
	protected static List<ThemeCollection> bulkThemes;
	private static ThemeRepository themeRepository;
	
	
	@Autowired
	public bulkWriteThemes(ThemeRepository themeRepository) {
		this.themeRepository = themeRepository;
	}
	
	private void generateInput() {
		themeRepository.deleteAll();
		
		//maxRecords = (long) Math.pow(2, 16) - 1; //short  -65535 to 65535
		maxRecords = 1000000 ;
		//maxRecords = (long)Math.pow(2,32); //int    -32,768 to 32767
		//maxRecords = (long)Math.pow(2,64); //long    -2,147,483,648 to 2,147,483,648
		bulkThemes = new ArrayList<>();
		
		for (int count = 0; count <= maxRecords; count++) {
			String name = new String("Manager" + count);
			ThemeCollection theme = new ThemeCollection((Integer) count, name);
			bulkThemes.add(theme);
		}
	}
	
	
	
	private void newbulkwrite() {
	
	}
	
	
	
	public boolean insertBulkThemes() {
		
		long sTime =  System.currentTimeMillis() ;
		generateInput();
		
		themeRepository.saveAll(bulkThemes);
		long totalTime = System.currentTimeMillis() - sTime ;
		System.out.println(" Exec Time: "+totalTime);
		
		return true;
	}
	
}

