package com.project.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.Answer;
import com.project.entity.Question;
import com.project.utility.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		storeData();

	}

	private static void storeData() {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				tx = session.beginTransaction();

				session.persist(getQuestion1());
				session.persist(getQuestion2());

				tx.commit();
				System.out.println("success");
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	private static Question getQuestion2() {
		Answer ans1 = new Answer();
		ans1.setAnswer("Servlet is an Interface");
		ans1.setPostedBy("Jai Kumar");

		Answer ans2 = new Answer();
		ans2.setAnswer("Servlet is an API");
		ans2.setPostedBy("Arun");

		List<Answer> list = new LinkedList<Answer>();
		list.add(ans1);
		list.add(ans2);

		Question question = new Question();
		question.setQuestion("What is Servlet?");
		question.setAnswers(list);

		return question;
	}

	private static Question getQuestion1() {
		Answer ans1 = new Answer();
		ans1.setAnswer("Java is a programming language");
		ans1.setPostedBy("Ravi Malik");

		Answer ans2 = new Answer();
		ans2.setAnswer("Java is a platform indepenedent language");
		ans2.setPostedBy("Sudhir Kumar");
		
		Answer ans3 = new Answer();
		ans3.setAnswer("Java is robust");
		ans3.setPostedBy("Dinesh");

		List<Answer> list = new LinkedList<Answer>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);

		Question question = new Question();
		question.setQuestion("What is Java?");
		question.setAnswers(list);

		return question;
	}

}
