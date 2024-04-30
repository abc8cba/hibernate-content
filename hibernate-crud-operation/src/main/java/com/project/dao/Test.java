package com.project.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.entity.Employee;
import com.project.utility.HibernateUtil;

public class Test {

	public static void main(String[] args) {
//		insertRecord();
//		updateRecord();
//		deleteRecord();
		searchRecord();
//		showAll();

	}

	private static void searchRecord() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				/*
				 * If the object present in cache or database then return object
				 * If the object does not present in cache or database then return null
				 */
				Employee employee1 = session.get(Employee.class, 3);
				Employee employee2 = session.get(Employee.class, 33);
				System.out.println(employee1);
				System.out.println(employee2);
				
				/*
				 * If the object present in cache or database then return object
				 * If the object does not present in cache or database then throws ObjectNotFoundException exception 
				 */
				Employee employee3 = session.load(Employee.class, 4);
				Employee employee4 = session.load(Employee.class, 33);
				System.out.println(employee3);
				System.out.println(employee4);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void showAll() {

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

	private static void deleteRecord() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				transaction = session.beginTransaction();
				Employee e1 = new Employee(1, "Ravi", "Lucknow");
				session.delete(e1);
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	private static void updateRecord() {
		//usingSaveOrUpdateMethod();
		usingUpdateMethod();
		//usingMergeMethod();

	}

	private static void usingMergeMethod() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				transaction = session.beginTransaction();
				Employee employee = session.get(Employee.class, 1 );
				System.out.println("Before merge: "+session.get(Employee.class, 1 ));
				Employee e1 = new Employee(1, "Ravi", "Heerapur");
				
				/*
				 * if object already present in the session cache then it will merge updated data in cache 
				 * and modify the record in database and return updated object back to us.
				 * if object is not present in the session cache then it will simply update the
				 * record and returns update object back to us.
				 */				
				Employee emp = (Employee)session.merge(e1);
				System.out.println("After merge: "+session.get(Employee.class, 1 ));
				System.out.println("After merge, record status in database table: "+emp);
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}

	private static void usingUpdateMethod() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				transaction = session.beginTransaction();
				
				Employee employee = session.get(Employee.class, 1 );
				Employee e1 = new Employee(1, "Ravi", "Mumbai");
				
				/*
				* If object present in session then update() will throw an exception i.e. NonUniqueObjectException 
				* If object is not present in session then update() will do update operation smoothly. 
				*/				
				session.update(e1);
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}

	private static void usingSaveOrUpdateMethod() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				transaction = session.beginTransaction();
				Employee e1 = new Employee(1, "Ravi", "Lucknow");
				Employee e12 = new Employee("Yogendra", "Jalandhar");
				
				/*
				 * if object already present then it will update the record in database
				 * if object is not present then new object will be created in database
				 */
				session.saveOrUpdate(e1);
				session.saveOrUpdate(e12);
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}

	private static void insertRecord() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			if (session != null) {
				
				transaction = session.beginTransaction();

//				Employee e1 = new Employee("Ravi", "Mumbai");
//				Employee e2 = new Employee("Neha", "Thane");
//				Employee e3 = new Employee("John", "Lucknow");
//				Employee e4 = new Employee("Keshav", "Noida");
//				Employee e5 = new Employee("Neeraj", "Jaunpur");
//				Employee e6 = new Employee("Lalit", "Pune");
//				Employee e7 = new Employee("Raj", "Prayagraj");
//				Employee e8 = new Employee("Jojo", "Varanasi");
//				Employee e9 = new Employee("Jonathan", "Merath");
//				Employee e10 = new Employee("Birendra", "Pune");
//				Employee e11 = new Employee("Kumud", "Mumbai");
//				
//				session.save(e1);
//				session.save(e1);
//				session.save(e2);
//				session.save(e3);
//				session.save(e4);
//				session.save(e5);
//				session.save(e6);
//				session.save(e7);
//				session.save(e8);
//				session.save(e9);
//				session.save(e10);
//				session.save(e11);

				
				
				
//				Employee e1 = new Employee(1,"Ravi", "Mumbai");
//				Employee e2 = new Employee(2,"Neha", "Thane");
//				Employee e3 = new Employee(3,"John", "Agra");
//				session.save(e1);
//				session.save(e2);
//				session.save(e3);
				
				//save() vs persist() method
				
				// save() will run fine either primary key exist or auto-increment
//				Employee e1 = new Employee(1, "Ravi", "Mumbai");
//				session.save(e1);
//
//				Employee e2 = new Employee("Ravi", "Mumbai");
//				session.save(e2);			
				
				

				// persist() Will throw exception if primary key value exists
//				Employee e1 = new Employee(1,"Ravi", "Mumbai");
//				session.persist(e1);

				// persist() Will not throw exception if primary key value does not exist
//				Employee e1 = new Employee("Ravi", "Mumbai");
//				session.persist(e1);

				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

}
