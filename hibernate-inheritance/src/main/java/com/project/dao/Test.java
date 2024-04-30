package com.project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.entity.Contract_Employee;
import com.project.entity.Employee;
import com.project.entity.Regular_Employee;
import com.project.utility.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();  
	    
	    Transaction t=session.beginTransaction();    
	    
	    Employee e1 = new Regular_Employee(1, "Ravi", 30000f, 4000);
	    Employee e2 = new Contract_Employee(2, "Neha", 500f, "20 Hours");
	    session.save(e1);
	    session.save(e2);  
	        
	    t.commit();    
	    session.close();    
	    System.out.println("success");    
	}

	private static void m1() {
		Configuration cfg = new Configuration();
//		if(cfg != null) {
//			Session session = cfg.configure("hibernate.cfg.xml").buildSessionFactory().getCurrentSession();
//		}
		cfg.configure("hibernate.cfg.xml");
		Session session = cfg.buildSessionFactory().openSession();
		// session.save(new Employee("Rohit", "Mumbai"));
		session.beginTransaction().commit();
	}

}
