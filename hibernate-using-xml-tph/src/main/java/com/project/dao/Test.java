package com.project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.entity.PartTimeEmployee;
import com.project.entity.Employee;
import com.project.entity.FullTimeEmployee;
import com.project.utility.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
	    Transaction t=session.beginTransaction();    
	    
	    Employee e1 = new FullTimeEmployee(1, "abc", 30000f, 4000);
	    Employee e2 = new PartTimeEmployee(2, "xyz", 500f, "20 Hours");
	    Employee e3 = new FullTimeEmployee(3, "Sandeep", 50000f, 7000);
	    Employee e4 = new PartTimeEmployee(4, "Mohit", 600f, "70 Hours");
	    session.save(e1);
	    session.save(e2);  
	    session.save(e3);
	    session.save(e4);  
	    t.commit();    
	    session.close();    
	    System.out.println("success");    
	}

	
	
	
}
