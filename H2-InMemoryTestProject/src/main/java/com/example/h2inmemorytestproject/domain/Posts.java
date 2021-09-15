package com.example.h2inmemorytestproject.domain;


@Enti
public class Posts {
	

	private long id;
	
	private int studentId  ;
	private String studentName ;
	
	
	public Posts() {
	}
	
	
	public Posts(int studentId, String studentName) {
		
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	@Override
	public String toString() {
		return "Posts{" +
			"studentId=" + studentId +
			", studentName='" + studentName + '\'' +
			'}';
	}
}