package com.project.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

				LinkedList<String> list1 = new LinkedList<String>();
				list1.add("Java is a programming language");
				list1.add("Java is a platform");

				LinkedList<String> list2 = new LinkedList<String>();
				list2.add("Servlet is an Interface");
				list2.add("Servlet is an API");

				Question question1 = new Question();
				question1.setQuestionName("What is Java?");
				question1.setAnswers(list1);

				Question question2 = new Question();
				question2.setQuestionName("What is Servlet?");
				question2.setAnswers(list2);

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

				TypedQuery query = session.createQuery("from Question");
				List<Question> list = query.getResultList();

				Iterator<Question> itr = list.iterator();
				System.out.println("====================================================");
				while (itr.hasNext()) {
					Question q = itr.next();
					System.out.println("Question Name: " + q.getQuestionName());

					// printing answers
					List<String> list2 = q.getAnswers();
					Iterator<String> itr2 = list2.iterator();
					System.out.println("-------------------------------------------------");
					while (itr2.hasNext()) {
						System.out.println(itr2.next());
					}
				}
				session.close();
				System.out.println("success");
			}
		}catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

}
