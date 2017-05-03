package org.mseco.learning.hibernate2.mappingCollections.ofValues;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory("org/mseco/learning/hibernate2/mappingCollections/ofValues/hibernate.cfg.xml").openSession();
		Transaction tx = session.beginTransaction();
		
		Item item = new Item();
		
		Image image = new Image();
		image.setName("home on the range");
		
		item.setNumbers(new int[]{1,2,3,4});
		
		item.getImages_names_unique().add("a");
		item.getImages_names_unique().add("a");
		
		item.getImages_names_duplicates().add("a");
		item.getImages_names_duplicates().add("a");
		
		
		item.getImages_bag().add(image);
		item.getImages_set().add(image);
		item.getImages_set_sorted().add(image);
		item.getImages_list().add(image);
		item.getImages_map().put("the key", image);
		item.getImages_map_sorted().put("the key", image);
		item.getImages_map_compositekey().put(image, image);
		
		session.persist(item);
		
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}

}
