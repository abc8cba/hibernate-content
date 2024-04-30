package com.project.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sessionFactory;
	
	static{		
		if(sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
		}
	}

	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

}
