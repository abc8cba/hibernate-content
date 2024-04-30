package com.project.entity;

public class Answer {
	private int id;
	private String answer;
	private String postedBy;

	public Answer() {

	}

	public Answer(int id, String answer, String postedBy) {
		this.id = id;
		this.answer = answer;
		this.postedBy = postedBy;
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

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", postedBy=" + postedBy + "]";
	}
	
	

}