package org.mseco.learning.hibernate2.api.hibernate;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Flush {
	public static void main(String[] args) {

		try {
			Session session = HibernateUtil.getSessionFactory(
					"org/mseco/learning/hibernate2/api/hibernate.cfg.xml")
					.openSession();
			// !!!
			session.setFlushMode(FlushMode.MANUAL); // useful in combining
													// stateful ejb with
													// stateless ejb dao to
													// create long running			
													// conversations
			//FlushMode.COMMIT; // usefull in series of: modify-query-modify-query... to avoid too many synchronizations before each query
			
			Transaction tx = session.beginTransaction();

			Message message = new Message();
			session.persist(message);

			
			
			tx.commit();
			// !!!
			session.flush();
			
			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
