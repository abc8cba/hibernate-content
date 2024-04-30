package com.project.entity;

import java.util.List;

public class Question {

	private int id;
	private String questionName;
	private List<String> answers;

	public Question() {
	}

	public Question(int id, String questionName, List<String> answers) {
		this.id = id;
		this.questionName = questionName;
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

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

}
