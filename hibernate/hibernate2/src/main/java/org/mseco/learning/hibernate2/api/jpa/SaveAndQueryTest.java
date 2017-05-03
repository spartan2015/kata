package org.mseco.learning.hibernate2.api.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.mseco.learning.hibernate2.start.JpaUtil;
import org.mseco.learning.hibernate2.start.Message;

public class SaveAndQueryTest {

	public static void main(String[] args) {
		try {
			EntityManager em = JpaUtil.getEntityManagerFacory()
					.createEntityManager();
			EntityTransaction etx = em.getTransaction();
			etx.begin();

			Message m = new Message();

			/*
			 *     Should I use persist() on the Session? The Hibernate Session interface also
    features a persist() method. It has the same semantics as the persist()
    operation of JPA. However, there’s an important difference between the
    two operations with regard to flushing. During synchronization, a Hiber-
    nate Session doesn’t cascade the persist() operation to associated enti-
    ties and collections, even if you mapped an association with this option.
    It’s only cascaded to entities that are reachable when you call persist()!
    Only save() (and update()) are cascaded at flush-time if you use the
    Session API. In a JPA application, however, it’s the other way round:
    Only persist() is cascaded at flush-time.
	 - p 419
			 */
			em.persist(m);

			List<Message> ms = em.createQuery("select m from Message m").getResultList();
			for(Message m1 : ms){
				System.out.println(m.getId());
			}
			
			etx.commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JpaUtil.shutdown();
		}
	}

}
