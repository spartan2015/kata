package org.mseco.learning.ejb_jpa.conversations;

import javax.persistence.EntityManager;

public class ExtendedContextStrategySimpleStyle {
	EntityManager em;
	
	ExtendedContextStrategySimpleStyle(EntityManager em){
		this.em = em;
	}
	
	public void doTransaction(){
		em.getTransaction().begin();
		/*
		 * From looking at this new conversation client code, when do you think the
updated item description is saved in the database? It depends on the flushing of
the persistence context. You know that the default FlushMode in JPA is AUTO, which
enables synchronization before a query is executed, and when a transaction is
committed. The atomicity of the conversation depends on the implementation of
the sellerHasEnoughMoney() method and whether it executes a query or com-
mits a transaction.
		this must be disabled in a long running conversation - reserved only for the last step
		of the conversation 
		
		
		    Hibernate offers org.hibernate.FlushMode.MANUAL, which decouples trans-
action demarcation from the synchronization. Unfortunately, due to disagree-
ments among the members of the JSR-220 expert group, javax.persis-
tence.FlushMode only offers AUTO and COMMIT. Before we show you the “official”
solution, here is how you can get FlushMode.MANUAL by falling back to a Hiber-
nate API:
   // Prepare Hibernate-specific EntityManager parameters
   Map params = new HashMap();
   params.put("org.hibernate.flushMode," "MANUAL");
   // Begin persistence context with custom parameters
   EntityManager em = emf.createEntityManager(params);
   // Alternative: Fall back and disable automatic flushing
   ((org.hibernate.Session)em.getDelegate())
      .setFlushMode(org.hibernate.FlushMode.MANUAL);


em.flush(); // MUST BE CALLED IN A MANUAL MODE




The official architectural solution relies on nontransactional behavior. Instead of
a simple FlushMode setting, you need to code your data-access operations without
transaction boundaries. One of the reasons given by expert group members about
the missing FlushMode is that “a transaction commit should make all modifica-
tions permanent.” So, you can only disable flushing for the second step in the
conversation by removing transaction demarcation:
   public class ManageAuction {
        ...
        public boolean sellerHasEnoughMoney(User seller) {
            boolean sellerCanAffordIt = (Boolean)
                 em.createQuery("select ...").getSingleResult();
            return sellerCanAffordIt;
        }
        ...
   }
This code doesn’t trigger a flush of the persistence context, because the Entity-
Manager is used outside of any transaction boundaries. The EntityManager that
executes this query is now working in autocommit mode, with all the interesting
consequences we covered earlier in section 10.3, “Nontransactional data access.”
Even worse, you lose the ability to have repeatable reads: If the same query is exe-
cuted twice, the two queries each execute on their own database connection in
autocommit mode. They can return different results, so the database transaction
isolation levels repeatable read and serializable have no effect. 
 p 505
		 */
		
		em.getTransaction().commit();
	}
}

// in this case we delegate to the client (Controller) to extends the EntityManagers life
/*
 * Naturally, an interceptor that wraps the getAuction() and endAuction() meth-
ods and supplies the correct EntityManager instance can be more convenient. It
also avoids the concern leaking upward to the presentation layer. You’d get this
interceptor for free if you wrote your controller as a stateful EJB session bean.

 */
class Controller{
	public void execute(){
		EntityManager em = null;
		
		new ExtendedContextStrategySimpleStyle(em);
		
		em.close();
	}
	
}
