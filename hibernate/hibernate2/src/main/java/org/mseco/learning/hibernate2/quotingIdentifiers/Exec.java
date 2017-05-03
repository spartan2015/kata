package org.mseco.learning.hibernate2.quotingIdentifiers;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {
	public static void main(String args[]) {
		Session session = HibernateUtil.getSessionFactory(
				"org/mseco/learning/hibernate2/quotingIdentifiers/hibernate.cfg.xml")
				.openSession();
		Transaction tx = session.beginTransaction();

		User user = new User();
		user.setName("MASTER ECO");

		session.persist(user);
		
		tx.commit();
		session.close();

		HibernateUtil.shutdown();

	}
}
