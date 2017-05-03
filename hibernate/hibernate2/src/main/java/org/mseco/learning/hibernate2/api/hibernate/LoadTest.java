package org.mseco.learning.hibernate2.api.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class LoadTest {

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
			
			// just returns a proxy - no hit occurs
			Message m = (Message)s2.load(Message.class, Long.valueOf(1));
			System.out.println("class: " + m.getClass()); // org.mseco.learning.hibernate2.api.Message$$EnhancerByCGLIB$$82ba6f71
			
			/**
			 *      The one difference between get() and load() is how they indicate that the
instance could not be found. If no row with the given identifier value exists in the
database, get() returns null. The load() method throws an ObjectNotFound-
Exception. It’s your choice what error-handling you prefer.
     More important, the load() method may return a proxy, a placeholder, without
hitting the database. A consequence of this is that you may get an ObjectNotFoun-
dException later, as soon as you try to access the returned placeholder and force
its initialization (this is also called lazy loading; we discuss load optimization in later
chapters.) The load() method always tries to return a proxy, and only returns an
initialized object instance if it’s already managed by the current persistence con-
text. In the example shown earlier, no database hit occurs at all!
- p 405
			 */
			
			tx2.commit();
			s2.close();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
