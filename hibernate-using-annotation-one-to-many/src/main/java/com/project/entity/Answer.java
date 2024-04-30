package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_ans100")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ans_id")
	private int id;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "posted_by")
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