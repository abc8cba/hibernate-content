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
		//fetchData();

	}

	private static void storeData() {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				tx = session.beginTransaction();

				//adding question and their answers			    
			    Question q1=new Question();  
			    q1.setQuestion("What is Java?");  
			    

				Answer ans1=new Answer();    
			    ans1.setAnswer("Java is a programming language");    
			    ans1.setPostedBy("Ravi Malik");    
			        
			    Answer ans2=new Answer();    
			    ans2.setAnswer("Java is a platform independent language");    
			    ans2.setPostedBy("Sudhir Kumar"); 
			    
			    List<Answer> list1=new LinkedList<Answer>();  
			    list1.add(ans1);  
			    list1.add(ans2);  
			    q1.setAnswers(list1);  
			        
			    //adding question and their answers 
			    Answer ans3=new Answer();    
			    ans3.setAnswer("Servlet is an Interface");    
			    ans3.setPostedBy("Jai Kumar");    
			        
			    Answer ans4=new Answer();    
			    ans4.setAnswer("Servlet is an API");    
			    ans4.setPostedBy("Arun"); 
			    
			    List<Answer> list2=new LinkedList<Answer>();  
			    list2.add(ans3);  
			    list2.add(ans4);  
			       
			     
			    Question q2=new Question();  
			    q2.setQuestion("What is Servlet?");
			    q2.setAnswers(list2);    
			       
			    //Keeping object in persistence state
			    session.persist(ans1);
			    session.persist(ans2);
			    session.persist(ans3);
			    session.persist(ans4);
			    session.persist(q1);    
			    session.persist(q2);    

			    //Passing data in table permanently
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
