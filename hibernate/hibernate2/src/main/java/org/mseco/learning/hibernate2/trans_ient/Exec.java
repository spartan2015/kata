package org.mseco.learning.hibernate2.trans_ient;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory(
				"org/mseco/learning/hibernate2/trans_ient/hibernate.cfg.xml")
				.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Person person = new Person();
		
		person.setFirstName("Master");
		person.setLastName("Doctor");
		person.setSex("MASCULINE");
		
		session.persist(person);
		
		tx.commit();		
		session.close();
		HibernateUtil.shutdown();
	}
}
