package org.mseco.learning.hibernate2.api.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.mseco.learning.hibernate2.start.JpaUtil;
import org.mseco.learning.hibernate2.start.Message;

public class DetachingTest {

	public static void main(String[] args) {
		try {
			EntityManager em = JpaUtil.getEntityManagerFacory()
					.createEntityManager();
			EntityTransaction etx = em.getTransaction();
			etx.begin();

			Message m = new Message();
			em.persist(m);

			em.clear(); // Note: EntityManager does not offer the hibernate
						// Session.evict() method but you can fallback to
						// Session
//						((Session)em.getDelegate()).evict(m);
			//
						// needless to say it will strongly couple your
						// persistence layer to hibernate

			etx.commit();
			em.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JpaUtil.shutdown();
		}
	}

}
