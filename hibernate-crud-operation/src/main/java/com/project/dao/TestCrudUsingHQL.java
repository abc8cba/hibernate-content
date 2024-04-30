package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.Employee;
import com.project.utility.HibernateUtil;

public class TestCrudUsingHQL {

	public static void main(String[] args) {
//		insertRecordUsingHQL();
		updateRecordUsingHQL();
//		deleteRecordUsingHQL();
//		searchRecordUsingHQL();
//		showAllUsingHQL();

	}
	
	private static void showAllUsingHQL() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				Query q1 = session.createQuery("from Employee");
				List<Employee> list = q1.list();
				System.out.println(list);
				for (Employee emp : list) {
					System.out.println(emp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void searchRecordUsingHQL() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				Query query = session.createQuery("from Employee where id =:id ");
				query.setParameter("id", 2);
				Employee emp = (Employee)query.uniqueResult();
				System.out.println(emp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void deleteRecordUsingHQL() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				transaction = session.beginTransaction();
				Query query = session.createQuery("delete from Employee where id = :id ");
				query.setParameter("id", 12);
				int rows = query.executeUpdate();
				//transaction.commit();
				if(rows>0) {
					System.out.println(rows+" Rows deleted");
				}else {
					System.out.println("Something went wrong to delete record");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	private static void updateRecordUsingHQL() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				transaction = session.beginTransaction();
				Query query = session.createQuery("update Employee set city= :city where id = :id ");
				query.setParameter("id", 1);
				query.setParameter("city", "Kanpur");
				int rows = query.executeUpdate();
				//transaction.commit();
				if(rows>0) {
					System.out.println(rows+" Rows updated");
				}else {
					System.out.println("Something went wrong to update record");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	private static void insertRecordUsingHQL() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				transaction = session.beginTransaction();
				Query query = session.createQuery("insert into DummyEmployee(id,name,city) select id,name,city from Employee  ");				
				int rows = query.executeUpdate();
				//transaction.commit();
				if(rows>0) {
					System.out.println(rows+" Rows inserted into dummy table");
				}else {
					System.out.println("Something went wrong to insert record");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}
