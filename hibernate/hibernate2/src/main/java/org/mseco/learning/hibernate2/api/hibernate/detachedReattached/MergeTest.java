package org.mseco.learning.hibernate2.api.hibernate.detachedReattached;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.api.Message;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class MergeTest {
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
		Message newMessageAttached = (Message)s2.merge(m);
		System.out.println((newMessageAttached == m) + " == false");
		/**
		 * the philosophy behind it:
		 * 
		 * Merging of a detached object is an alternative approach. It can be complementary
to or can replace reattachment. Merging was first introduced in Hibernate to deal
with a particular case where reattachment was no longer sufficient (the old name
for the merge() method in Hibernate 2.x was saveOrUpdateCopy()).

Given is a detached item object with the database identity 1234. After modifying
it, you try to reattach it to a new Session. However, before reattachment, another
instance that represents the same database row has already been loaded into the
persistence context of that Session. Obviously, the reattachment through
update() clashes with this already persistent instance, and a NonUniqueObjectEx-
ception is thrown. The error message of the exception is A persistent instance with
the same database identifier is already associated with the Session! Hibernate can’t decide
which object represents the current state.
- p 411-412
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
