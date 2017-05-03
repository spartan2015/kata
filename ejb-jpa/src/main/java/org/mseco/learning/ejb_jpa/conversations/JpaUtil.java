package org.mseco.learning.ejb_jpa.conversations;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory entityManagerFactory;
	public static EntityManagerFactory getEntityManagerFactory(){
		if (entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory("helloworld");
		}
		return entityManagerFactory;
	}
	
	public static void shutdown(){
		entityManagerFactory.close();
	}
}
