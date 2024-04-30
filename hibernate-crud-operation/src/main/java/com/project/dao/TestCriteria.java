package com.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.project.entity.Employee;
import com.project.utility.HibernateUtil;

public class TestCriteria {

	public static void main(String[] args) {
		searchRecordUsingCriteria();
		//showAllUsingCriteria();

	}
	
	private static void showAllUsingCriteria() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				
				Criteria cr = session.createCriteria(Employee.class);
				List<Employee> list = cr.list();
				
				for (Employee emp : list) {
					System.out.println(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	private static void searchRecordUsingCriteria() {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				
				Criteria cr = session.createCriteria(Employee.class);
				//Restrictions will be used to apply where condition
				Criteria criteria = cr.add(Restrictions.eq("id", 1));
				Employee uniqueResult = (Employee)criteria.uniqueResult();
				System.out.println(uniqueResult);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
