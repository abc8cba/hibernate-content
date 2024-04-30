package com.project.dao;

import org.hibernate.Session;

public class Test {	

	public static void main(String[] args) {
		usingXmlBasedConfiguration();
		//usingJavaBasedConfiguration();
	}
	private static void usingJavaBasedConfiguration () {
		try(Session session = HibernateUtil.getSessionFactory2().openSession() ) {
			String result = (String)session.createNativeQuery("select version()").getSingleResult();
			System.out.println("Version is: "+result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	static void usingXmlBasedConfiguration(){
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			String result = (String)session.createNativeQuery("select version()").getSingleResult();
			System.out.println("Version is: "+result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
