package org.mseco.learning.hibernate2.api.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;

import org.mseco.learning.hibernate2.start.JpaUtil;
import org.mseco.learning.hibernate2.start.Message;

public class FlushModeTest {

	public static void main(String[] args) {
		try {
			EntityManager em = JpaUtil.getEntityManagerFacory()
					.createEntityManager();
			em.setFlushMode(FlushModeType.COMMIT); // even with this the insert is done before the query - weird ha ?
			EntityTransaction etx = em.getTransaction();
			etx.begin();

			System.out.println(em.getFlushMode()); // damn FlushMode.AUTO this contradicts this:
			/*
			 *     The persistence context of an EntityManager is flushed whenever commit()
on an EntityTransaction is called. All the previous code examples in this section
of the chapter have been using that strategy. However, JPA implementations are
allowed to synchronize the persistence context at other times, if they wish.
Hibernate, as a JPA implementation, synchronizes at the following times:  
■ When an EntityTransaction is committed  
■ Before a query is executed  
■ When the application calls em.flush() explicitly

Switching the FlushModeType to COMMIT for an EntityManager disables automatic
synchronization before queries; it occurs only when the transaction is committed
or when you flush manually. The default FlushModeType is AUTO. - boy the contradictions

- p 422 - this has been contradicted by reality check
			 */
			
			
			
			Message m = new Message();
			em.persist(m);
		
			
			System.out.println("query now - in jpa we should not see the insert yet");
			List<Message> ms = (List<Message>)em.createQuery("select m from Message m").getResultList();
			
			
			System.out.println("now commiting");
			etx.commit();
			em.close();
		
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JpaUtil.shutdown();
		}
	}

}
