package org.mseco.learning.hibernate2.mappingTypes.customTypes;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	public static void main(String[] args) {
		Session session = HibernateUtil
				.getSessionFactory(
						"org/mseco/learning/hibernate2/mappingTypes/customTypes/hibernate.cfg.xml",
						false).openSession();
		Transaction tx = session.beginTransaction();

		for(String currencyCode : new String[]{"USD"}){
			EntityExample ee = new EntityExample();			
			MonetaryAmount ma = new MonetaryAmount();
			ma.setAmount(new BigDecimal(100));
			ma.setCurrency(Currency.getInstance(currencyCode));			
			ee.setMa(ma);
			ee.setMaComposite(ma);
			ee.setMaParameterized(ma);
			
			session.persist(ee);
		}		
		
		
		
		List<EntityExample> list = (List<EntityExample>)session.createQuery("from EntityExample").list();
		for(EntityExample eee : list){
			System.out.println("amount: " + eee.getMa().getAmount() + ", currency: " + eee.getMa().getCurrency());
		}

		// Datorita faptului ca Type-ul implementeaza CompositeUserType putem folosi proprietatile in interogare
		Query query = session.createQuery("from EntityExample ee where ee.maComposite.currency = :currency");
		query.setString("currency","USD");
		
		List<EntityExample> list1 = (List<EntityExample>)query.list();
		
		for(EntityExample eee : list1){
			System.out.println("amount: " + eee.getMa().getAmount() + ", currency: " + eee.getMa().getCurrency());
		}
		
		tx.commit();
		session.close();
		HibernateUtil.shutdown();

	}
}
