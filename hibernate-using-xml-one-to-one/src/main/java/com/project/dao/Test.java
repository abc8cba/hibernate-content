package com.project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.Address;
import com.project.entity.Person;
import com.project.utility.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		storeData();
		// fetchData();

	}

	private static void storeData() {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				tx = session.beginTransaction();
				
			    session.persist(getFirstPerson()); 
			    session.persist(getSecondPerson()); 
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

	private static Person getSecondPerson() {

		Person p2=new Person();    
	    p2.setName("Sandeep Singh");    
	        
	    Address address2=new Address();    
	    address2.setLandmark("Near Petrol Pump");    
	    address2.setCityName("Mumbai");    
	    address2.setStateName("Maharastra");    
	    address2.setCountryName("India");    
	    address2.setPincode("400072");    
	        
	    p2.setAddress(address2);    
	    address2.setPerson(p2); 
		return p2;
	}

	private static Person getFirstPerson() {
		Person p1=new Person();    
	    p1.setName("Ravi Malik");    
	        
	    Address address1=new Address();    
	    address1.setLandmark("Near Temple");    
	    address1.setCityName("Ghaziabad");    
	    address1.setStateName("UP");    
	    address1.setCountryName("India");    
	    address1.setPincode("201301");    
	        
	    p1.setAddress(address1);    
	    address1.setPerson(p1); 
		return p1;
	}

}
