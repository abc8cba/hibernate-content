package com.project.dao;

import java.util.ArrayList;
import java.util.List;

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
	    
	    //address1  	        
	    Address address1=new Address();    
	    address1.setLandmark("Near Temple");    
	    address1.setCityName("Agra");    
	    address1.setStateName("Uttar Pradesh");    
	    address1.setCountryName("India");    
	    address1.setPincode("201301");
	       
	    //address2
	    Address address2=new Address();    
	    address2.setLandmark("Near Petrol Pump");    
	    address2.setCityName("Mumbai");    
	    address2.setStateName("Maharastra");    
	    address2.setCountryName("India");    
	    address2.setPincode("400072");
	    
	    //address3
	    Address address3=new Address();    
	    address3.setLandmark("Near Ganda nala");    
	    address3.setCityName("Kanpur");    
	    address3.setStateName("Uttar Pradesh");    
	    address3.setCountryName("India");    
	    address3.setPincode("555666"); 
	    
	    List<Address> addresses = new ArrayList<>();
	    addresses.add(address1);
	    addresses.add(address2);
	    addresses.add(address3);
	        
	    p2.setAddress(addresses);    
		return p2;
	}

	private static Person getFirstPerson() {
		Person p1=new Person();    
	    p1.setName("Ravi Malik");    
	        
	    Address address1=new Address();    
	    address1.setLandmark("Near Post Office");    
	    address1.setCityName("Surat");    
	    address1.setStateName("Gujrat");    
	    address1.setCountryName("India");    
	    address1.setPincode("201897");
	    
	    List<Address> addresses = new ArrayList<>();
	    addresses.add(address1);     
	    p1.setAddress(addresses);    
		return p1;
	}

}
