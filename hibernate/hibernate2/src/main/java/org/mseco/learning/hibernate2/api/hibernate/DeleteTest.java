package org.mseco.learning.hibernate2.api.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class DeleteTest {

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
						
			Message m = (Message)s2.load(Message.class, Long.valueOf(1));
			
			s2.delete(m);
			
			/**
			 *     Do I have to load an object to delete it? Yes, an object has to be loaded into
    the persistence context; an instance has to be in persistent state to be
    removed (note that a proxy is good enough).
    
    !!!
    Hibernate can also roll back the identifier of any entity that has been deleted, if
you enable the hibernate.use_identifier_rollback configuration option. In
the previous example, Hibernate sets the database identifier property of the
deleted item to null after deletion and flushing, if the option is enabled. It’s then
a clean transient instance that you can reuse in a future unit of work.

    - p 407 

			 */
			
			tx2.commit();
			s2.close();			
			
			System.out.println("id after delete:" + m.getId());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
