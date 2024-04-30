package com.project.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.Emp;
import com.project.utility.HibernateUtil;

public class TestClient {

	public static void main(String[] args) {
		insert();

	}

	private static void insert() {
		Transaction tx = null;
		try {			
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			if(session != null) {
				Emp e1 = new Emp("Ravi", "Mumbai");
				Emp e2 = new Emp("Neha", "Thane");
				Emp e3 = new Emp("John", "Lucknow");
				Emp e4 = new Emp("Keshav", "Noida");
				
				session.save(e1);
				session.save(e2);
				
				
				//System.out.println(10/0);
				session.save(e3);
				session.save(e4);
				
				tx.commit();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}

}
