package org.mseco.learning.hibernate2.api.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.mseco.learning.hibernate2.start.JpaUtil;
import org.mseco.learning.hibernate2.start.Message;

public class GetReferenceTest {

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

			EntityManager em2 = JpaUtil.getEntityManagerFacory()
					.createEntityManager();
			EntityTransaction etx2 = em2.getTransaction();
			etx2.begin();

			// !!!
			Message mx = em2.getReference(Message.class, Long.valueOf(1)); // the
																			// proxy
																			// that
																			// may
																			// return
																			// may
																			// throw
																			// a
																			// EntityNotFoundException
																			// on
																			// intitialization

			System.out.println(mx);

			etx2.commit();
			em2.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JpaUtil.shutdown();
		}
	}

}
