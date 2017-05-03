package org.mseco.learning.ejb_jpa;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.xml.registry.infomodel.User;
/*
 *    Another reason for accessing your EntityManagerFactory may be that you
want to access a particular vendor extension on this interface, like we discussed in
chapter 2, section 2.2.4, “Switching to Hibernate interfaces.”

 */
@Stateless
public class AccessingEntityManagerFactory {
	@PersistenceUnit(unitName="auctionDB")
	EntityManagerFactory emf;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void finUserById(Long id){
		EntityManager em = emf.createEntityManager();
		
		em.find(User.class, id);
		
		em.flush();
		em.close();
		
	}
	/*
	 *     You may create an EntityManager outside of any JTA transaction boundaries;
for example, in an EJB method that doesn’t require a transaction context. It’s
then your responsibility to notify the EntityManager that a JTA transaction is
active, when needed, with the joinTransaction() method. Note that this opera-
tion doesn’t bind or scope the persistence context to the JTA transaction; it’s only
a hint that switches the EntityManager to transactional behavior internally.
    The previous statements aren’t complete: If you close() the EntityManager, it
doesn’t immediately close its persistence context, if this persistence context has
been associated with a transaction. The persistence context is closed when the
transaction completes. However, any call of the closed EntityManager throws an
exception (except for the getTransaction() method in Java SE and the
isOpen() method). You can switch this behavior with the hibernate.
ejb.discard_ pc_on_close configuration setting. You don’t have to worry about
this if you never call the EntityManager outside of transaction boundaries.

	 */
	
}
