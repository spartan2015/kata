package org.mseco.learning.hibernate2.polymorphicAssociations.unions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil
					.getSessionFactory(
							"org/mseco/learning/hibernate2/polymorphicAssociations/unions/hibernate.cfg.xml",
							false).openSession();
			Transaction tx = session.beginTransaction();

			CreditCard cc = new CreditCard();
			cc.setCardNumber("card1");
			session.persist(cc);
			
			User user = new User();
			user.getBillingDetails().add(cc);
			cc.setUser(user);
			session.persist(user);
			
			tx.commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}

	}

}
