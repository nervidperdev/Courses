package com.nervidper.courses.online.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoUtility {

	public static Session getSession() {
		
		Configuration conf = new Configuration();
		conf.configure(); // leyendo el fichero hibernate.cfg.xml
			
		SessionFactory factory = conf.buildSessionFactory();
		Session sesion = factory.openSession();
		
		return sesion;
		
	}
	
}
