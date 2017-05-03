package org.mseco.learning.hibernate2.inheritance.tablePerConcreteClassWithUnions;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.mseco.learning.hibernate2.start.JpaUtil;

public class JpaExec {

	
	public static void main(String[] args) {
		EntityManagerFactory emf = JpaUtil.getEntityManagerFacory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		CreditCard cc = new CreditCard();
		cc.setCardNumber(1234567890);
		cc.setExpDate(new Date() );
		cc.setDate(new Date());
		em.persist(cc);
		
		BankAccount ba = new BankAccount();
		ba.setIban("ROBRDE2189812138237293218732838282828282281891248912477992481");
		ba.setCurrency("RON");
		ba.setDate(new Date());
		em.persist(ba);
		
		// well this query does not work - BillingDetails entity is not recognized
		List<BillingDetails> bds = (List<BillingDetails>)em.createQuery("select * from BillingDetails").getResultList();
		for(BillingDetails bd : bds){
			System.out.println(bd.getClass());
		}
		
		
		tx.commit();
		em.close();
		emf.close();

	}

}
