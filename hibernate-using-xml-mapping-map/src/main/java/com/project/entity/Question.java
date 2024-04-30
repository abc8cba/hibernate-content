package com.project.entity;

import java.util.Map;

public class Question {

	private int id;
	private String questionName;
	private String questionAskedByUser;
	private Map<String, String> answers;

	public Question() {

	}

	public Question(int id, String questionName, String questionAskedByUser, Map<String, String> answers) {
		super();
		this.id = id;
		this.questionName = questionName;
		this.questionAskedByUser = questionAskedByUser;
		this.answers = answers;
	}

	public Question(String questionName, String questionAskedByUser, Map<String, String> answers) {
		super();
		this.questionName = questionName;
		this.questionAskedByUser = questionAskedByUser;
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionAskedByUser() {
		return questionAskedByUser;
	}

	public void setQuestionAskedByUser(String questionAskedByUser) {
		this.questionAskedByUser = questionAskedByUser;
	}

	public Map<String, String> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<String, String> answers) {
		this.answers = answers;
	}

}
