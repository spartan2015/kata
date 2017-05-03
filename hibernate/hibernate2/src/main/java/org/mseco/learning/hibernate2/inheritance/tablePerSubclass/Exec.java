package org.mseco.learning.hibernate2.inheritance.tablePerSubclass;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class Exec {

	public static void main(String[] args) {
		Session session = HibernateUtil
				.getSessionFactory(
						"org/mseco/learning/hibernate2/inheritance/tablePerSubclass/hibernate.cfg.xml"
						,true)
				.openSession();
		Transaction tx = session.beginTransaction();

		CreditCard cc = new CreditCard();
		cc.setCardNumber(1234567890);
		cc.setExpDate(new Date() );
		cc.setDate(new Date());
		session.persist(cc);
		
		BankAccount ba = new BankAccount();
		ba.setIban("ROBRDE2189812138237293218732838282828282281891248912477992481");
		ba.setCurrency("RON");
		ba.setDate(new Date());
		session.persist(ba);
		
		// well this query does not work - BillingDetails entity is not recognized
		List<BillingDetails> bds = (List<BillingDetails>)session.createQuery("from BillingDetails").list();
		for(BillingDetails bd : bds){
			System.out.println(bd.getClass());
		}
		
		tx.commit();
		session.close();
		HibernateUtil.shutdown();

	}

}
