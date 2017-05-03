package org.mseco.learning.hibernate2.associations.manyToManyWithAdditionalColumnOnIntermediateTable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	public static void main(String[] args) {
		try{
		Session session = HibernateUtil
				.getSessionFactory(
						"org/mseco/learning/hibernate2/associations/manyToManyWithAdditionalColumnOnIntermediateTable/hibernate.cfg.xml",false)
				.openSession();
		Transaction tx = session.beginTransaction();
		
		Category category = new Category(); 
		Item item = new Item();
		session.persist(category);
		session.persist(item);		
		
		CategorizedItem ci = new CategorizedItem(category, item, "description");			
		
		session.save(ci);
		
		tx.commit();
		session.close();		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{ // finally alone in a main method will swallow any exception !!!
			HibernateUtil.shutdown();
		}
	}

}
