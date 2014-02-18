package br.com.rinete.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		} catch (Throwable e) {
			// TODO: handle exception
			throw new ExceptionInInitializerError(e);
		}

	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	

}
