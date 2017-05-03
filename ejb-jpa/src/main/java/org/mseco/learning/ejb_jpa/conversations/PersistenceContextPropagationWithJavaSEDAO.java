package org.mseco.learning.ejb_jpa.conversations;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersistenceContextPropagationWithJavaSEDAO {

	public void hibernateStyle() {

		// session progragation in java se was with thread locale and
		// getCurrentSession();
		HibernateUtil.getSessionFactory().getCurrentSession();

	}

	public void jpaStyle() {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager(); // observe no getCurrentSession - no
										// propagation with threadLocal - you
										// must keep this object reference in
										// some place for the entire duration of
										// the covnersation
									//        this is the session-per-
									//        operation antipattern we identified earlier!

		/*
		 *Solutions to this antipattern
		 *
  You can instantiate an EntityManager for the whole DAO when the DAO is
  created. This doesn’t get you the persistence-context-per-request scope, but it’s
  slightly better than one persistence context per operation. However, trans-
  action demarcation is still an issue with this strategy; all DAO operations on
  all DAOs still can’t be grouped as one atomic and isolated unit of work.
 
 
   You can instantiate a single EntityManager in your controller and pass it
  into all DAOs when you create the DAOs (constructor injection). This solves
  the problem. The code that handles an EntityManager can be paired with
  transaction demarcation code in a single location, the controller.
  
  
    You can instantiate a single EntityManager in an interceptor and bind it to
  a ThreadLocal variable in a helper class. The DAOs retrieve the current
  EntityManager from the ThreadLocal. This strategy simulates the getCur-
  rentSession() functionality in Hibernate. The interceptor can also
  include transaction demarcation, and you can wrap the interceptor around
  your controller methods. Instead of writing this infrastructure yourself, con-
  sider EJBs first.


		 */
		
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		tx.commit();

	}

}
