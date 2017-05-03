package org.mseco.learning.jpaejb;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
@Local
@PersistenceUnit(name= "emf/auction", unitName = "auctionDB") // II. option 
public class LookupEntityManagerFactory {

	// I. option
	@PersistenceUnit(unitName="helloworld")
	EntityManagerFactory emf;
	
	//II. option
	@Resource
	SessionContext sc;
	
	@TransactionAttribute
	public void doATransaction(){
		// I. option
		/*
		 *                                                The EntityManager you created
from the injected factory is again application-managed—the container won’t
flush this persistence context, nor close it.
		 */
		EntityManager em = emf.createEntityManager();
		// II. option
		EntityManagerFactory emf = (EntityManagerFactory)sc.lookup("em/auctionDB");
		
		/*
		 *     You may create an EntityManager outside of any JTA transaction boundaries;
for example, in an EJB method that doesn’t require a transaction context. It’s
then your responsibility to notify the EntityManager that a JTA transaction is
active, when needed, with the joinTransaction() method.

		 */
		em.joinTransaction();
		// or
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();		
//		tx.commit();
		
		
		/*
		 *    The previous statements aren’t complete: If you close() the EntityManager, it
doesn’t immediately close its persistence context, if this persistence context has
been associated with a transaction. The persistence context is closed when the
transaction completes.
		 */
		em.close();
	}
}
