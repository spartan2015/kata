package org.mseco.learning.hibernate2.api.hibernate.detachedReattached;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class UpdateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		SessionFactory sf = HibernateUtil.getSessionFactory("org/mseco/learning/hibernate2/api/hibernate.cfg.xml");
		Session s1 = sf.openSession();
		Transaction tx1 = s1.beginTransaction();
		
		Message m = new Message();
		s1.persist(m);
		
		tx1.commit();
		s1.close();
		
		// mopdify in detached state:
		m.setText("onward ! to glory !");
		
		Session s2 = sf.openSession();
		Transaction tx2 = s2.beginTransaction();
		
		// REATTACH
		s2.update(m);
		/**
		 * It doesn’t matter if the item object is modified before or after it’s passed to
update(). The important thing here is that the call to update() is reattaching the
detached instance to the new Session (and persistence context). Hibernate
always treats the object as dirty and schedules an SQL UPDATE., which will be exe-
cuted during flush.
p 409
                                  One way to avoid this UDPATE statement is to
configure the class mapping of Item with the select-before-update="true"
attribute. Hibernate then determines whether the object is dirty by executing a
SELECT statement and comparing the object’s current state to the current data-
base state.
p 410
		 */
		tx2.commit();
		s2.close();	
		
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			HibernateUtil.shutdown();
		}

	}

}
