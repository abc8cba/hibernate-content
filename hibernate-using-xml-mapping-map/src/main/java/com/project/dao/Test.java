package com.project.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.Question;
import com.project.utility.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		storeData();
		fetchData();

	}

	private static void storeData() {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				tx = session.beginTransaction();

				HashMap<String, String> answer1 = new HashMap<String, String>();
				answer1.put("Java is a programming language", "John Milton");
				answer1.put("Java is a platform", "Ashok Kumar");

				HashMap<String, String> answer2 = new HashMap<String, String>();
				answer2.put("Servlet technology is a server side programming", "John Milton");
				answer2.put("Servlet is an Interface", "Ashok Kumar");
				answer2.put("Servlet is a package", "Rahul Kumar");

				Question question1 = new Question("What is Java?", "Alok", answer1);
				Question question2 = new Question("What is Servlet?", "Jai Dixit", answer2);

				session.persist(question1);
				session.persist(question2);

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

	private static void fetchData() {

		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				tx = session.beginTransaction();

				TypedQuery query = session.createQuery("from Question ");
				List<Question> list = query.getResultList();

				Iterator<Question> iterator = list.iterator();
				System.out.println("================================================================");
				while (iterator.hasNext()) {
					Question question = iterator.next();
					System.out.println("question id:" + question.getId());
					System.out.println("question name:" + question.getQuestionName());
					System.out.println("question posted by:" + question.getQuestionAskedByUser());
					System.out.println("answers.....");
					System.out.println("-------------------------------------------------------------");
					Map<String, String> map = question.getAnswers();
					Set<Map.Entry<String, String>> set = map.entrySet();

					Iterator<Map.Entry<String, String>> iteratoranswer = set.iterator();
					while (iteratoranswer.hasNext()) {
						Map.Entry<String, String> entry = (Map.Entry<String, String>) iteratoranswer.next();
						System.out.println("answer name:" + entry.getKey());
						System.out.println("answer posted by:" + entry.getValue());
					}
				}
				session.close();
				System.out.println("success");
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

}
