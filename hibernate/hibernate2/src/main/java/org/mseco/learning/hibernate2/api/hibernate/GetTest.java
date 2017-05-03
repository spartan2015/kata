package org.mseco.learning.hibernate2.api.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class GetTest {

	public static void main(String[] args) {
		
		try {
			Session session = HibernateUtil
					.getSessionFactory(
							"org/mseco/learning/hibernate2/api/hibernate.cfg.xml")
					.openSession();
			Transaction tx = session.beginTransaction();

			Message message = new Message();			
			session.persist(message);
						
			tx.commit();
			session.close();
			
			Session s2 = HibernateUtil
			.getSessionFactory(
					"org/mseco/learning/hibernate2/api/hibernate.cfg.xml")
			.openSession();
			Transaction tx2 = s2.beginTransaction();
			
			//!!! get triggers an immediate database hit !
			Message m = (Message)s2.get(Message.class, Long.valueOf(1));
			
			tx2.commit();
			s2.close();			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
