package com.project.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.Address;
import com.project.entity.Person;
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
				
				firstManyToOneRelation(session);
				secondManyToOneRelation(session);
				
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

	private static void firstManyToOneRelation(Session session) {
		Person person1=new Person();    
	    person1.setName("Nilesh Singh");			    
	    
		Person person2=new Person();    
	    person2.setName("Sandeep Singh");    
	        
	    Address address1=new Address();    
	    address1.setLandmark("Near Temple");    
	    address1.setCityName("Ghaziabad");    
	    address1.setStateName("UP");    
	    address1.setCountryName("India");    
	    address1.setPincode("201301");
	    
	    person1.setAddress(address1);
	    person2.setAddress(address1);
	    
	    session.save(person1);
	    session.save(person2);
	    session.save(address1);
		
	}
	
	private static void secondManyToOneRelation(Session session) {
		Person person1=new Person();    
	    person1.setName("Umesh");			    
	    
		Person person2=new Person();    
	    person2.setName("Nisha");    
	        
	    Address address1=new Address();    
	    address1.setLandmark("Near Petrol Pump");    
	    address1.setCityName("Agra");    
	    address1.setStateName("UP");    
	    address1.setCountryName("India");    
	    address1.setPincode("201405");
	    
	    person1.setAddress(address1);
	    person2.setAddress(address1);
	    
	    session.save(person1);
	    session.save(person2);
	    session.save(address1);
		
	}

}
