package com.example.h2database.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
public class ThemeCollection {
	
	@Id
	private BigInteger id ;
	
	private Integer themeId ;
	private String themeName ;
	
	
	public ThemeCollection() {
	}
	
	public ThemeCollection(BigInteger id, Integer themeId, String themeName) {
		this.id = id;
		this.themeId = themeId;
		this.themeName = themeName;
	}
	
	public BigInteger getId() {
		return id;
	}
	
	public void setId(BigInteger id) {
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
