package org.mseco.learning.hibernate2.api.hibernate.detachedReattached;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class LockTest {
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
		s2.lock(m,LockMode.NONE); // assumes no change was made to this detached instance !!!!!!!!!!!!!!!!!!!! and it reattaches it
		// only changes done after lock are propagated with dirty read check, to the database
		// use this only if you are SURE that the object was not modified prior to lock
		
		/*
		 *                                                              By specifying Lock-
Mode.NONE here, you tell Hibernate not to perform a version check or obtain any
database-level locks when reassociating the object with the Session. 
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
