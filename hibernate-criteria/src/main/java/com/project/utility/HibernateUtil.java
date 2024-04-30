package com.project.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				// hibernate.cfg.xml file is default configuration file
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
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

}
