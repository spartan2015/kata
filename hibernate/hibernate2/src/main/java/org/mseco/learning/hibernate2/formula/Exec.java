package org.mseco.learning.hibernate2.formula;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory(
				"org/mseco/learning/hibernate2/formula/hibernate.cfg.xml")
				.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Person person = new Person();
		
		person.setFirstName("Master");
		person.setLastName("Doctor");
		person.setSex("MASCULINE");
		
		session.persist(person);
		
		
		
		System.out.println(person.getFormula());
		
		tx.commit();		
		session.close();
		HibernateUtil.shutdown();
	}
}
