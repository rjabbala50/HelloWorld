package com.example.persistsdemo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Posts {
	
	@Id
	@GeneratedValue
	Long id ;
	
	String FirstName;
	
	public Posts() {
	}
	
	public Posts(Long id, String firstName) {
		this.id = id;
		FirstName = firstName;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	@Override
	public String toString() {
		return "Posts{" +
			"id=" + id +
			", FirstName='" + FirstName + '\'' +
			'}';
	}
}
