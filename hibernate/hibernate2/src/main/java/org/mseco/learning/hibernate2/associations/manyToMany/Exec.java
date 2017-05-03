package org.mseco.learning.hibernate2.associations.manyToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	public static void main(String[] args) {
		try{
		Session session = HibernateUtil
				.getSessionFactory(
						"org/mseco/learning/hibernate2/associations/manyToMany/hibernate.cfg.xml",false)
				.openSession();
		Transaction tx = session.beginTransaction();
		
		Category category = new Category();
		Item item = new Item();
		
		category.getItems().add(item);
		item.getCategories().add(category);
		
		session.save(category);
		
		tx.commit();
		session.close();
		}finally{
			HibernateUtil.shutdown();
		}
	}

}
