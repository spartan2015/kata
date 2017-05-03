package org.mseco.learning.hibernate2.api.hibernate.detachedReattached;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class DeleteTest {
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
		
		// REATTACH & DELETE IN ONE METHOD delete(Object o )
		s2.delete(m);
		
		tx2.commit();
		s2.close();	
		
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			HibernateUtil.shutdown();
		}

	}
}
