package com.project.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.project.entity.Emp;
import com.project.utility.HibernateUtil;

public class TestClient {

	public static void main(String[] args) {

		//insertRecords();
		//showAllUsingCriteria();
		showDataUsingCodition();
		

	}

	private static void showDataUsingCodition() {
		//Salary greater than 50000
		//greaterThan();
		//lesserThan();
		equalCodition();
		
	}

	private static void greaterThan() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			if (session != null) {
				Criteria criteria = session.createCriteria(Emp.class);
				criteria.add(Restrictions.gt("salary", 50000.0));
				List<Emp> list = criteria.list();
				for (Emp emp : list) {
					System.out.println(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void lesserThan() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			if (session != null) {
				Criteria criteria = session.createCriteria(Emp.class);
				criteria.add(Restrictions.le("salary", 50000.0));
				List<Emp> list = criteria.list();
				for (Emp emp : list) {
					System.out.println(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void equalCodition() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			if (session != null) {
				Criteria criteria = session.createCriteria(Emp.class);
				criteria.add(Restrictions.eq("salary", 25000.0));
				List<Emp> list = criteria.list();
				for (Emp emp : list) {
					System.out.println(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void showAllUsingCriteria() {

		showAll();
		System.out.println("---------------------------------------------------------\n");
		showRangeData();

	}

	private static void showAll() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			if (session != null) {
				Criteria criteria = session.createCriteria(Emp.class);
				List<Emp> list = criteria.list();
				for (Emp emp : list) {
					System.out.println(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void showRangeData() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			if (session != null) {
				Criteria criteria = session.createCriteria(Emp.class);
				criteria.setFirstResult(1);
				criteria.setMaxResults(3);
				List<Emp> list = criteria.list();
				for (Emp emp : list) {
					System.out.println(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void insertRecords() {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {

				tx = session.beginTransaction();

				Emp e1 = new Emp("Ravi", "Mumbai", 5000.0);
				Emp e2 = new Emp("Neha", "Thane", 15000.0);
				Emp e3 = new Emp("John", "Lucknow", 51000.0);
				Emp e4 = new Emp("Keshav", "Noida", 4000.0);
				Emp e5 = new Emp("Neeraj", "Jaunpur", 55000.0);
				Emp e6 = new Emp("Lalit", "Pune", 45000.0);
				Emp e7 = new Emp("Raj", "Prayagraj", 35000.0);
				Emp e8 = new Emp("Jojo", "Varanasi", 25000.0);
				Emp e9 = new Emp("Jonathan", "Merath", 95000.0);
				Emp e10 = new Emp("Birendra", "Pune", 25000.0);
				Emp e11 = new Emp("Abhishek", "Mumbai", 85000.0);
				Emp e12 = new Emp("Kareena", "Pune", 65000.0);
				Emp e13 = new Emp("Janhvi", "Mumbai", 75000.0);
				Emp e14 = new Emp("Mukesh", "Pune", 8000.0);
				Emp e15 = new Emp("Harish", "Mumbai", 9000.0);
				Emp e16 = new Emp("Dinesh", "Nagpur", 11000.0);

				session.save(e1);
				session.save(e1);
				session.save(e2);
				session.save(e3);
				session.save(e4);
				session.save(e5);
				session.save(e6);
				session.save(e7);
				session.save(e8);
				session.save(e9);
				session.save(e10);
				session.save(e11);
				session.save(e12);
				session.save(e13);
				session.save(e14);
				session.save(e15);
				session.save(e16);

				tx.commit();
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
