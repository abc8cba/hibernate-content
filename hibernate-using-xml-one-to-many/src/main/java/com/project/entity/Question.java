package com.project.entity;

import java.util.List;

public class Question {

	private int id;
	private String question;
	private List<Answer> answers;

	public Question() {
	}

	public Question(int id, String question, List<Answer> answers) {
		super();
		this.id = id;
		this.question = question;
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answers=" + answers + "]";
	}
	
	

}
