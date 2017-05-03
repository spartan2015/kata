package learning.hibernate.query.leftJoinOutRAGE;

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
		
		Item two = new Item();
		two.setName("two");
		
		session.persist(two);
		
		Bid bid = new Bid();
		bid.setValue(new BigDecimal(10));		
		two.addBid(bid);		
		
		
		
		Query query = session.createQuery("select i from Item i left join i.bids b where b.value > 0 ");
		System.out.println(query.getQueryString());
		List<Item> items = (List<Item>)query.list();
		for(Item i : items){
			System.out.println(i.getName());
		}
		//"where b.value" - results inner join not because of the phare but because a null bid can't have a value > 0 - so you get an inner join practicly even though the pharse never said so 
		//- "with b.value" is the LEFT OUTER JOIN
		// read the sql result
		System.out.println(query.getQueryString());
		query = session.createQuery("select i from Item i left join i.bids b with b.value > 0 ");
		items = (List<Item>)query.list();
		for(Item i : items){
			System.out.println(i.getName());
		}
		
		/*
		 * Hibernate: 
    insert 
    into
        Item
        (name) 
    values
        (?)
Hibernate: 
    insert 
    into
        Item
        (name) 
    values
        (?)
select i from Item i left join i.bids b where b.value > 0 
Hibernate: 
    insert 
    into
        Bid
        (value, Item_id) 
    values
        (?, ?)
Hibernate: 
    select
        item0_.Item_id as Item1_0_,
        item0_.name as name0_ 
    from
        Item item0_ 
    left outer join
        Bid bids1_ 
            on item0_.Item_id=bids1_.Item_id 
    where
        bids1_.value>0
two
select i from Item i left join i.bids b where b.value > 0 
Hibernate: 
    select
        item0_.Item_id as Item1_0_,
        item0_.name as name0_ 
    from
        Item item0_ 
    left outer join
        Bid bids1_ 
            on item0_.Item_id=bids1_.Item_id 
            and (
                bids1_.value>0
            )
One
two

		 */
		
		session.getTransaction().commit();
				
		session.close();
		HibernateUtil.shutdown();
		
	}
}
