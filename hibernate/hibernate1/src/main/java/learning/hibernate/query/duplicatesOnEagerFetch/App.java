package learning.hibernate.query.duplicatesOnEagerFetch;

import java.math.BigDecimal;
import java.util.List;

import learning.hibernate.app.HibernateUtil;
import learning.hibernate.query.leftJoinOutRAGE.entities.Bid;
import learning.hibernate.query.leftJoinOutRAGE.entities.Item;

import org.hibernate.Query;
import org.hibernate.Session;

public class App {
	public static void main(String... args){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Item item = new Item();
		item.setName("One");
		
		session.persist(item);
		
		for(int i = 0; i < 2; i++){
			Bid b = new Bid();
			b.setValue(new BigDecimal(i));
			item.addBid(b);
		}
		
		Query query = session.createQuery("from Item i left join fetch i.bids"); 
		List<Item> items = query.list();
		System.out.println("Result size: " + items.size()); // 2 - even though there is only one Item in the database
		System.out.println("items.get(0) == items.get(1): " + (items.get(0) == items.get(1))); // identical objects - different references
		
		// you must use distinct or you could wrap the list in a set = nodupes = new LinkedHashSet(items);
		
		session.getTransaction().commit();
				
		session.close();
		HibernateUtil.shutdown();
		
	}
}
