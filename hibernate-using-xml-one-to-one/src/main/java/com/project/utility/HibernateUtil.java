package com.project.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sessionFactory;

	static {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
		}
	}

	// Way1 Can be configure like this,this will be good coding practice
	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	//OR
	// Way2 Can be configure like this but will be not good coding practice
	public static SessionFactory getSessionFactoryWay2() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}

	//OR
	// Way3 Can be configure like this,this will be good coding practice
	public static SessionFactory getSessionFactoryWay3() {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;
	}

}
