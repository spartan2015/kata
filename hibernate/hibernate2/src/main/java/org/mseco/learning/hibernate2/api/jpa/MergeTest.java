package org.mseco.learning.hibernate2.api.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.mseco.learning.hibernate2.start.JpaUtil;
import org.mseco.learning.hibernate2.start.Message;

public class MergeTest {

	public static void main(String[] args) {
		try {
			EntityManager em = JpaUtil.getEntityManagerFacory()
					.createEntityManager();
			EntityTransaction etx = em.getTransaction();
			etx.begin();

			Message m = new Message();
			em.persist(m);

			etx.commit();
			em.close();
			
			// DETACHED STATE:some modifications
			m.setText("modiciation of persistent message in detached state");			
			//
			
			EntityManager em2 = JpaUtil.getEntityManagerFacory().createEntityManager();
			EntityTransaction tx2 = em2.getTransaction();
			tx2.begin();
			
			Message newMessage = em2.merge(m);
			System.out.println(newMessage == m);
			
			tx2.commit();
			em2.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JpaUtil.shutdown();
		}
	}

}
