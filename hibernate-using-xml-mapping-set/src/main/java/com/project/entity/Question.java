package com.project.entity;

import java.util.Set;

public class Question {

	private int id;
	private String questionName;
	private Set<String> answers;

	public Question() {
	}

	public Question(int id, String questionName, Set<String> answers) {
		super();
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

	public Set<String> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<String> answers) {
		this.answers = answers;
	}

}
