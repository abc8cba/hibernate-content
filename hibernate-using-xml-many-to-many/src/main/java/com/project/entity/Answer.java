package com.project.entity;

import java.util.List;

public class Answer {
	private int id;
	private String answer;
	private String postedBy;
	private List<Question> questions;

	public Answer() {

	}

	public Answer(int id, String answer, String postedBy, List<Question> questions) {
		this.id = id;
		this.answer = answer;
		this.postedBy = postedBy;
		this.questions = questions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}