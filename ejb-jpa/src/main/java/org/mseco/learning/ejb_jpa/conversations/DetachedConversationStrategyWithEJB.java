package org.mseco.learning.ejb_jpa.conversations;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import learning.hibernate.entities.Category;



@Stateful
public class DetachedConversationStrategyWithEJB {

	@PersistenceContext
	EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void doer(){
		// merge detached objects into the persistence context
		Category c = new Category();
		
		Category mergedCategory = em.merge(c);
		
	}
	
}
