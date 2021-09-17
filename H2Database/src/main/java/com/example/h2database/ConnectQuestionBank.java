package com.example.h2database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;


@Document
public class ConnectQuestionBank {
	
	@Id
	private BigInteger id ;
	private  String question ;
	
	public ConnectQuestionBank() {
	}
	
	public ConnectQuestionBank(BigInteger id, String question) {
		this.id = id;
		this.question = question;
	}
	
	public BigInteger getId() {
		return id;
	}
	
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "ConnectQuestionBank{" +
			"id=" + id +
			", question='" + question + '\'' +
			'}';
	}
}
