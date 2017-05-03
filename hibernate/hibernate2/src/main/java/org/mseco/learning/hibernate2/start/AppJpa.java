package org.mseco.learning.hibernate2.start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AppJpa {
	public static void main(String args[]){
		EntityManager em = JpaUtil.getEntityManagerFacory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Message m = new Message();
		m.setText("jpa message");
		
		em.persist(m);
		
		tx.commit();
		em.close();
		
		
		EntityManager em2 = JpaUtil.getEntityManagerFacory().createEntityManager();
		EntityTransaction tx2 = em2.getTransaction();
		tx2.begin();
		
		List<Message> messages = (List<Message>)em2.createQuery("select m from Message m").getResultList();
		for(Message message : messages){
			System.out.println("message: " + message.getText());
		}
		
		tx2.commit();
		em2.close();		
		JpaUtil.shutdown();
	}
}
