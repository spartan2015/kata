package org.mseco.learning.hibernate2.start;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;
import org.mseco.learning.hibernate2.naming.NamingStrategyMultiClientInstalation;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory(){
		if (sessionFactory == null){		
			sessionFactory = 	
//				new Configuration() // hibernate mapping files
				new AnnotationConfiguration() // annotations 
									/*
									 When new Configuration() is called, Hibernate searches for a file named
									hibernate.properties in the root of the classpath. If it’s found, all hibernate.*
									properties are loaded and added to the Configuration object.
									
													*/
					.configure("org/mseco/learning/hibernate2/start/hibernate.cfg.xml") // read by default hibernate.cfg.xml - or you can supply a String location for it
								 // it returns a configuration of hibernate very usefull
								/*
								      When configure() is called, Hibernate searches for a file named hiber-
										nate.cfg.xml in the root of the classpath, and an exception is thrown if it can’t
										be found. You don’t have to call this method if you don’t have this configuration
										file, of course. If settings in the XML configuration file are duplicates of proper-
										ties set earlier, the XML settings override the previous ones.
								 */
						.buildSessionFactory();
			
			Statistics stats = sessionFactory.getStatistics();
			stats.setStatisticsEnabled(true);
						
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(String configFile){
		if (sessionFactory == null){
			sessionFactory = new Configuration().configure(configFile).buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(String configFile, boolean annotations){
		if (sessionFactory == null){
			if (annotations){
				sessionFactory = new AnnotationConfiguration().configure(configFile).buildSessionFactory();
			}
			else{
				sessionFactory = new Configuration().configure(configFile).buildSessionFactory();
			}
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(String configFile, String tablePrefix){
		if (sessionFactory == null){
			Configuration conf = new Configuration(); 
			
			if (tablePrefix != null){
				conf.setNamingStrategy(new NamingStrategyMultiClientInstalation(tablePrefix));
			}
			
			sessionFactory = conf.configure(configFile).buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static void shutdown(){
		sessionFactory.close(); // if you have a create-drop on schema - this is the call that trigger the schema deletion
	}
}
