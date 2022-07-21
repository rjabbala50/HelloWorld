package com.example.h2database.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document("Questions")
public class ConnectQuestionBank             {
	
	@Id
	private String id ;
	
	private Integer questionId ;
	private String question ;
	private List <AnswerData> answerList ;
	private Integer themeId ;
	
	/* Json structure for Answer to this question
	Answer:[
			{"ansId":1, "choice":"String"}.
			{"ansId":2, "choice":"String"}.
			{"ansId":3, "choice":"String"}.
			{"ansId":4, "choice":"String"}
		    ]
	 */
	//Option-1 to take these Collections but I favour
	//List<Map<Long,String >> answer ;
	
	public static class AnswerData {
		private Integer ansId ;
		private String answer ;
		
		public AnswerData() {
		}
		
		public AnswerData(Integer i, String first_answer_choice) {
			ansId=i;
			answer = first_answer_choice ;
		}
		
		
		public Integer getAnsId() {
			return ansId;
		}
		
		
		public void setAnsId(Integer ansId) {
			this.ansId = ansId;
		}
		
		public String getAnswer() {
			return answer;
		}
		
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		
	} //AnswerData
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<AnswerData> getAnswerList() {
		return answerList;
	}
	
	public void setAnswerList(List<AnswerData> answerList) {
		this.answerList = answerList;
	}
	
	public Integer getThemeId() {
		return themeId;
	}
	
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	
	
	@Override
	public String toString() {
		return "ConnectQuestionBank{" +
			"id=" + id +
			", questionId=" + questionId +
			", question='" + question + '\'' +
			", answerList=" + answerList +
			", themeId=" + themeId +
			'}';
	}
	
}
