package org.mseco.learning.ejb_jpa;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.xml.registry.infomodel.User;

/*
 * Again, there is no particular advantage if you compare the lookup technique with
automatic injection.

 */
@Stateless
@PersistenceContext(name="emf/auction",unitName="auctionDB")
public class LookupEntityManagerFactory {
	
	@Resource
	SessionContext ctx;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void findUserById(Long id){
		EntityManagerFactory emf = (EntityManagerFactory)ctx.lookup("emf/auction");
		
		EntityManager em = emf.createEntityManager();
		
		em.find(User.class, id);
		
		em.flush();
		em.close();
		
	}

}
