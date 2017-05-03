package org.mseco.learning.hibernate2.associations.oneToOne;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {
	public static void main(String[] args) {
		Session session = HibernateUtil
				.getSessionFactory(
						"org/mseco/learning/hibernate2/associations/oneToOne/hibernate.cfg.xml")
				.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		Address address = new Address();
		
		address.setUser(user);
		user.setAddress(address);
		
		session.save(user);
		
		Query q = session.createQuery("from User");
		List<User> users = q.list();
		
		for(User u : users){
			System.out.println(u);
		}
		
		
		
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
}
