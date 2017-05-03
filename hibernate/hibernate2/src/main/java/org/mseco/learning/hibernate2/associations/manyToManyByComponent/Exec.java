package org.mseco.learning.hibernate2.associations.manyToManyByComponent;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	public static void main(String[] args) {
		try{
		Session session = HibernateUtil
				.getSessionFactory(
						"org/mseco/learning/hibernate2/associations/manyToManyByComponent/hibernate.cfg.xml")
				.openSession();
		Transaction tx = session.beginTransaction();
	
		Category category = new Category();
			
		Item item = new Item();		
		
		session.save(item);
		
		
		CategorizedItem ci = new CategorizedItem();		
		ci.setItem(item);
		ci.setDescription("description of the item");
		ci.setDate(new Date());
		category.getCategorizedItems().add(ci);		
		
		session.save(category);
		session.flush();
			
		session.evict(item);
		Query q = session.createQuery("from Item");
		List<Item> items = q.list();
		for(Item i : items){
			System.out.println(i.getId());
			for(CategorizedItem ci2 : i.getCategorizedItems()){
				System.out.println(ci2.getDescription());
			}
		}
		
		
		tx.commit();
		session.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			HibernateUtil.shutdown();
		}
	}
}
