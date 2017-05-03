package org.mseco.learning.hibernate2.mappingTypes.enumTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory("org/mseco/learning/hibernate2/mappingTypes/enumTypes/hibernate.cfg.xml").openSession();
		Transaction tx = session.beginTransaction();
		
		Person person = new Person();
		person.setRating(Rating.GOOD);
		session.persist(person);
		
		tx.commit();
		session.close();
		HibernateUtil.shutdown();		

	}
}
