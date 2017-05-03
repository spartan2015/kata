package org.mseco.learning.jpaejb;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local
@PersistenceContext(name="em/auction",unitName="helloworld")
/*
 *                                                   First, you declare that you want
the component environment of the bean populated with an EntityManager and
that the name of the bound reference is supposed to be em/auction. The full
name in JNDI is java:comp/env/em/auction—the java:comp/env/ part is the so
called bean-naming context. Everything in that subcontext of JNDI is bean-depen-
dent. In other words, the EJB container reads this annotation and knows that it
has to bind an EntityManager for this bean only, at runtime when the bean exe-
cutes, under the namespace in JNDI that is reserved for this bean.

 */
public class LookupThePersistenceContext {

	/*
	 * @Resource annotation instructs the EJB container to inject the SessionContext
for you.
	 */
	@Resource
	SessionContext sc;
	
	@TransactionAttribute
	public void doATransaction(){
		/**
		 *    You look up the EntityManager in your bean implementation with the help of
the SessionContext. The benefit of this context is that it automatically prefixes
the name you’re looking for with java:comp/env/; hence, it tries to find the refer-
ence in the bean’s naming context, and not the global JNDI namespace.

		 */
		EntityManager em = (EntityManager)sc.lookup("em/auction");
				
	}	
}
