package org.mseco.learning.hibernate2.api.persistenceContextCache;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class PersistenceContextCacheTest {

	public static void main(String[] args) {
		
		try {
			Session session = HibernateUtil
					.getSessionFactory(
							"org/mseco/learning/hibernate2/api/hibernate.cfg.xml")							
							.openSession();
			// 1. to avoid memory problems you could instantiate a statelessSession
			// .openStatelessSession()
					
			Transaction tx = session.beginTransaction();

			Message message = new Message();			
			session.persist(message);
			
			// 2. you can disable dirty checking
			session.setReadOnly(message, true);
			
			// 3. you can evict an entity from session
			session.evict(message);
			
			// 4. you can clear the entire session
			session.clear();
						
			tx.commit();
			session.close();
						
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
