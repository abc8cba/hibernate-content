package com.project.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.Answer;
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

				Answer ans1=new Answer();    
			    ans1.setAnswer("Java is a programming language");    
			    ans1.setPostedBy("Ravi Malik");    
			        
			    Answer ans2=new Answer();    
			    ans2.setAnswer("Java is a platform");    
			    ans2.setPostedBy("Sudhir Kumar");    
			        
			    Answer ans3=new Answer();    
			    ans3.setAnswer("Servlet is an Interface");    
			    ans3.setPostedBy("Jai Kumar");    
			        
			    Answer ans4=new Answer();    
			    ans4.setAnswer("Servlet is an API");    
			    ans4.setPostedBy("Arun");    
			        
			    List<Answer> list1=new LinkedList<Answer>();    
			    list1.add(ans1);    
			    list1.add(ans2);    
			        
			    List<Answer> list2=new LinkedList<Answer>();   
			    list2.add(ans3);    
			    list2.add(ans4);    
			        
			    Question question1=new Question();    
			    question1.setQuestion("What is Java?");    
			    question1.setAnswers(list1);   
			        
			    Question question2=new Question();    
			    question2.setQuestion("What is Servlet?");    
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
					System.out.println("Question Name: " + q.getQuestion());

					// printing answers
					List<Answer> list2 = q.getAnswers();
					Iterator<Answer> itr2 = list2.iterator();
					System.out.println("-------------------------------------------------");
					while (itr2.hasNext()) {
						Answer answer = itr2.next();
						System.out.println("Answer: "+answer.getAnswer()+"\nPosted by: "+answer.getPostedBy());
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
