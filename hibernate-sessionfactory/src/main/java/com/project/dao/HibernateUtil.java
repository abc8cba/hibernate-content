package com.project.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				//hibernate.cfg.xml file is default configuration file
				//standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
				//myconfig.xml file is user-defined configuration file
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure("myconfig.xml").build();
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
				return sessionFactory;
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (standardServiceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
		}
		return sessionFactory;
	}

//-------------------------------- OR----------------------------------------------------------------------
//	static {
//		try {
//			if (sessionFactory == null) {
//				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
//				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
//				Metadata metadata = metadataSources.getMetadataBuilder().build();
//				sessionFactory = metadata.getSessionFactoryBuilder().build();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (standardServiceRegistry != null) {
//				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
//			}
//		}
//	}
//	public static SessionFactory getSessionFactory() {
//		
//		return sessionFactory;
//	}

	//-------------------------------- OR----------------------------------------------------------------------


	public static SessionFactory getSessionFactory2() {
		if (sessionFactory == null) {
			Map<String, String> settings = new HashMap<>();
			settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
			settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
			settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb");
			settings.put("hibernate.connection.username", "root");
			settings.put("hibernate.connection.password", "root");
			settings.put("hibernate.show_sql", "true");
			settings.put("hibernate.format_sql", "true");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();
			MetadataSources metadataSources = new MetadataSources(serviceRegistry);
			Metadata metadata = metadataSources.buildMetadata();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			return sessionFactory;
		}
		return sessionFactory;
	}

}
