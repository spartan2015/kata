package org.mseco.learning.hibernate2.mappingMaps;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil
					.getSessionFactory(
							"org/mseco/learning/hibernate2/mappingMaps/hibernate.cfg.xml",
							true).openSession();
			Transaction tx = session.beginTransaction();

			Item item = new Item();
			Bid bid = new Bid();
			
			session.saveOrUpdate(bid);
			
			item.getBids().put(bid.getId(), bid);
			
			session.save(item);
			
			tx.commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}

	}

}
