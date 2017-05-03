package org.mseco.learning.hibernate2.polymorphicAssociations.implicit;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	public static void main(String[] args) {
		try {
			Session session = HibernateUtil
					.getSessionFactory(
							"org/mseco/learning/hibernate2/polymorphicAssociations/implicit/hibernate.cfg.xml")
					.openSession();
			Transaction tx = session.beginTransaction();

			CreditCard cc = new CreditCard();
			session.persist(cc);
			
			User user = new User();
			user.setBillingDetails(cc);
			
			session.persist(user);
			
			List<User> users = (List<User>)session.createQuery("from User").list();
			System.out.println(users.get(0).getBillingDetails());
			
			tx.commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}

	}

}
