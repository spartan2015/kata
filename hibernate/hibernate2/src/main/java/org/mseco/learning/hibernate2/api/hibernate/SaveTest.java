package org.mseco.learning.hibernate2.api.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class SaveTest {

	public static void main(String[] args) {
		
		try {
			Session session = HibernateUtil
					.getSessionFactory(
							"org/mseco/learning/hibernate2/api/hibernate.cfg.xml")
					.openSession();
			Transaction tx = session.beginTransaction();

			Message message = new Message();			
			
			Serializable id = session.save(message);
			
			System.out.println("id returned by save: " + id);
						
			tx.commit();
			session.close(); // persistence context ends here:
			
					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
