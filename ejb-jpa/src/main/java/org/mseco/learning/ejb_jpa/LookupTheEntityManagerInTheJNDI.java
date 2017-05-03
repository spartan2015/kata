package org.mseco.learning.ejb_jpa;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.registry.infomodel.User;

@Stateless
@PersistenceContext(name="em/auction",unitName="auctionDB")
/*
 * Several things are happening in this code snippet: First, you declare that you want
the component environment of the bean populated with an EntityManager and
that the name of the bound reference is supposed to be em/auction. The full
name in JNDI is java:comp/env/em/auction—the java:comp/env/ part is the so
called bean-naming context. Everything in that subcontext of JNDI is bean-depen-
dent. In other words, the EJB container reads this annotation and knows that it
has to bind an EntityManager for this bean only, at runtime when the bean exe-
cutes, under the namespace in JNDI that is reserved for this bean.
 */
public class LookupTheEntityManagerInTheJNDI {

		
	@Resource
	SessionContext ctx;
	
	public void findUserById(Long id){
		EntityManager em = (EntityManager)ctx.lookup("em/auction");
		/*
		 *     SessionContext. The benefit of this context is that it automatically prefixes
the name you’re looking for with java:comp/env/; hence, it tries to find the refer-
ence in the bean’s naming context, and not the global JNDI namespace.
		 */
		/*
		 *    A persistence context is created by the container when the first method on the
EntityManager is called, and it’s flushed and closed when the transaction ends—
when the method returns.

		 */
		em.find(User.class, id);
		
	}
}
