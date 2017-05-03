package org.mseco.learning.hibernate2.api.hibernate;

import java.io.Serializable;

import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class ReplicateTest {

	public static void main(String[] args) {
		
		try {
			SessionFactory sf1 = HibernateUtil.getSessionFactory("org/mseco/learning/hibernate2/api/hibernate.cfg.xml");
			SessionFactory sf2 = new Configuration().configure("org/mseco/learning/hibernate2/api/hibernate.postgres.cfg.xml").buildSessionFactory();
			
			
			Session session = sf1.openSession();
			Transaction tx = session.beginTransaction();

			Message message = new Message();			
			
			Serializable id = session.save(message);
			
			System.out.println("id returned by save: " + id);
						
			tx.commit();
			session.close(); // persistence context ends here:
			
			
			Session s2 = sf2.openSession();
			Transaction tx2 = s2.beginTransaction();
			
			s2.replicate(message, ReplicationMode.LATEST_VERSION);
			/**
			 *   ReplicationMode.IGNORE—Ignores the object when there is an existing
■
  database row with the same identifier in the target database.
  ReplicationMode.OVERWRITE—Overwrites any existing database row with
■
  the same identifier in the target database.
  ReplicationMode.EXCEPTION—Throws an exception if there is an existing
■
  database row with the same identifier in the target database.
  ReplicationMode.LATEST_VERSION—Overwrites the row in the target
■
  database if its version is earlier than the version of the object, or ignores
  the object otherwise. Requires enabled Hibernate optimistic concurrency
  control.

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
