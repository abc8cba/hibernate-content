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
		
		char array[][] = new char[3][2];
        for(int i=0;i<=2;i++){
            for(int j = 0; j<=1; j++){
                System.out.println("array["+i+"]["+j+"] = "+array[i][j]);
            }
        }
		
//		Session session=HibernateUtil.getSessionFactory().openSession();
//	    Transaction t=session.beginTransaction();    
//	    
//	    Employee e1 = new FullTimeEmployee(1, "Harish", 30000f, 4000);
//	    Employee e2 = new PartTimeEmployee(2, "Monica", 500f, "20 Hours");
//	    session.save(e1);
//	    session.save(e2);  
//	        
//	    t.commit();    
//	    session.close();    
//	    System.out.println("success");    
	}

}
