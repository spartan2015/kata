package org.mseco.learning.hibernate2.transactions;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class ForceRollbackInEJBEnvironment {
	@PersistenceContext
	EntityManager em;
	
	public void doATransaction() throws Exception{
		
		// you transactional code
		
		throw new MySpecialAnnotatedException(); // this special annotated exception will cause a rollback
		
	}
}
