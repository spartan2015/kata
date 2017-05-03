package org.mseco.learning.hibernate2.start;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory emf;
	public static EntityManagerFactory getEntityManagerFacory(){
		if (emf == null){
			emf = Persistence.createEntityManagerFactory("helloworld");		
			/*
			 * On startup, the Persistence.createEntityManagerFactory() method tries to
locate the persistence unit named helloworld. It searches the classpath for all
META-INF/persistence.xml files and then configures the EMF if a match is found.
The second part of the log shows something you probably didn’t expect. The JPA
persistence provider tried to find all annotated classes and all Hibernate XML
mapping files in the build output directory. The list of annotated classes (or the
list of XML mapping files) in hibernate.cfg.xml isn’t needed, because hello.Mes-
sage, the annotated entity class, has already been found.
Hibernate in Action p 77
			 */
		}		
		return emf;
	}
	
	public static void shutdown(){
		getEntityManagerFacory().close();
	}
}
