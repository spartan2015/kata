package org.mseco.learning.hibernate2.mappingMaps.ternary;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		Session session = HibernateUtil
				.getSessionFactory(
						"org/mseco/learning/hibernate2/mappingMaps/ternary/hibernate.cfg.xml")
				.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		session.persist(user);
		Item item = new Item();
		session.persist(item);
		
		Category category = new Category();
		category.getItems().put(item, user);
		session.persist(category);
		
		tx.commit();
		session.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			HibernateUtil.shutdown();
		}
	}

}
