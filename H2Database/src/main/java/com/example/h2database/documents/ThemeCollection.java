package com.example.h2database.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;

@Document ("Themes")
public class ThemeCollection {
	
	@Id
	private String id ;
	
	private Integer themeId ;
	private String themeName ;
	
	
	public ThemeCollection() {
	}
	
	public ThemeCollection(String id, Integer themeId, String themeName) {
		this.id = id;
		this.themeId = themeId;
		this.themeName = themeName;
	}
	
	public ThemeCollection(Integer themeId, String themeName) {
		this.themeId = themeId;
		this.themeName = themeName;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getThemeId() {
		return themeId;
	}
	
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	
	public String getThemeName() {
		return themeName;
	}
	
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
}
