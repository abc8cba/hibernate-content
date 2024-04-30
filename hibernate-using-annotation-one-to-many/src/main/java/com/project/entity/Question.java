package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_ques100")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ques_id")
	private int id;
	
	@Column(name = "question")
	private String question;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="qid")  
	@OrderColumn(name="type")
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
