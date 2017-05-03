package org.mseco.learning.ejb_jpa;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.registry.infomodel.User;

@Stateless
/*
 * Also note that all EJB session beans default to CMT, so if you want to disable CMT
and call the JTA UserTransaction directly in any session bean method, annotate
the EJB class with @TransactionManagement(TransactionManagementType.
BEAN). You’re then working with bean-managed transactions (BMT). Even if it may
work in most application servers, mixing CMT and BMT in a single bean isn’t
allowed by the Java EE specification.

 */
public class Basic {
	@PersistenceContext
	EntityManager em;
		
	// or setter injection
//	@PersistenceContext
//	public void setEm(EntityManager em){
//		this.em = em;
//	}
	
	// only for EJB 3.0
//	@PersistenceContext
//	Session session;
	
	/*
	 *    The persistence context of the injected container-managed EntityManager is
bound to the scope of the transaction, Hence, it’s flushed automatically and
closed when the transaction ends. 

  You have to set some configuration options to enable CMT with Hibernate:
   The hibernate.transaction.factory_class option must be set to org.
■
   hibernate.transaction.CMTTransactionFactory.
   You need to set hibernate.transaction.manager_lookup_class to the
■
   right lookup class for your application server.


	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
//	@TransactionAttribute(TransactionAttributeType.REQUIRED_NEW)
//	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
//	@TransactionAttribute(TransactionAttributeType.MANDATORY)
//	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void findUserById(Long id){
		em.find(User.class, id);
	}
	
}
