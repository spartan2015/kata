package org.mseco.learning.ejb_jpa.conversations;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceProperty;

import org.mseco.learning.ejb_jpa.ItemDao;
import org.mseco.learning.ejb_jpa.PaymentDao;

/*
 *     We’ve observed that applications that have been constructed with an extended
persistence context strategy are often easier to understand than applications that rely
heavily on detached objects.

   We don’t have much more to say about detached entity instances and how you
can merge modifications between persistence contexts in a conversation—the
concept and the API to use are exactly the same in Java SE and with EJBs.

the last conversation method will be marked with:
@TransactionAttribute(TransactionAttributeType.REQUIRED)
 */
@Stateful
/*
 * if you don't use hibernate flushmode manual:
 
Disabling flushing by disabling transactions
The official solution, according to the EJB 3.0 specification, mixes these two con-
cerns. You prevent automatic flushing by making all steps of the conversation
(except the last one) nontransactional:

 */
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
/*
 * we have, a limitation though because of NOT_SUPPORTED above:
 * 
 * 
 *     If you implement your DAOs as stateless session beans, as you did before, they
won’t inherit the extended persistence context if they are called from a nontrans-
actional method in a stateful controller. This is the stateful controller again, call-
ing a DAO:

 *     If you implement your DAOs as stateful session beans, they inherit the persis-
tence context from the calling stateful session bean controller. In this case, the
persistence context is propagated through instantiation, not through transaction
propagation.
   Write your DAOs as stateful EJBs if you write your controller as a stateful session
bean. This issue is another nasty side effect of the missing FlushMode.MANUAL that
can seriously impact how you design and layer applications. We recommend you
rely on the Hibernate extension until the EJB 3.0 (or 3.1?) specification is fixed.
With FlushMode.MANUAL, your controllers don’t have to use TransactionAt-
tributeType.NOT_SUPPORTED, and the persistence context is always propagated
along with your transaction (and you can mix stateless and stateful EJB calls easily).


- THE BEST IS USE STATEFULL FOR CONTROLLER + Hibernate flusmode Manul + statless Dao - this will
propagate the extendet context properly - with the transaction propagation - and you will have a healthy
extended conversation and persistence context
- second best is to disable  Transaction on the controller statefull class: with not_supported but in this 
case you must also have statefull daos - you can the persistence context propagation only to statefull 
ejb called from the controller - that's it. STATEFULL - this is a LIMITATION in design.
 hibernate in action - page 514 pdf 
 */
public class ExtendedContextStrategyWithEjb {

	/*
	 * JPA and EJB 3.0 define how the persistence context is handled in an application
and the rules that apply if several classes (or EJB components) use an EntityMan-
ager. The most common case in an application with EJBs is a container-managed
and injected EntityManager. You turn the ItemDAO class into a managed stateless
EJB component with an annotation, and rewrite the code to use EntityManager

The EJB container injects an EntityManager when a client of this bean calls get-
MaxBid(). The persistence context for that EntityManager is the current persis-
tence context (more about this soon). If no transaction is in progress when
getMaxBid() is called, a new transaction is started and committed when getMax-
Bid() returns.

   When ItemDAO and PaymentDAO, both stateless components, are invoked inside
the system transaction, both inherit the persistence context scoped to the transac-
tion. The container injects an EntityManager instance into itemDAO and pay-
mentDAO with the current persistence context behind the scenes.


  EntityManager is invoked for the first time, a persistence context begins.
  By default, it’s transaction-scoped and closes when the system transaction
  is committed or rolled back. It’s automatically flushed when the transac-
  tion is committed.


  If a stateless component (such as ItemDAO) is invoked, and the caller has
  an active transaction and the transaction is propagated into the called
  component (because ItemDAO methods require or support transactions),
  any persistence context bound to the JTA transaction is propagated with
  the transaction.

  If a stateless component (such as ItemDAO) is invoked, and the caller
  doesn’t have an active transaction (for example, ManageAuction.endAuc-
  tion() doesn’t start a transaction), or the transaction isn’t propagated into
  the called component (because ItemDAO methods don’t require or support
  a transaction), a new persistence context is created when the EntityMan-
  ager is called inside the stateless component. In other words, no propaga-
  tion of a persistence context occurs if no transaction is propagated.

   Also remember that you need nontransactional data access in JPA, to disable
automatic flushing of the persistence context in a long conversation—the prob-
lem of the missing FlushMode.MANUAL again. - p 509

	 */
	
/*

   If you want to implement a conversation with EJBs and an extended persistence
context, you have two choices:

   ■    You can write a stateful session bean as a conversation controller. The persis-   
       tence context can be automatically scoped to the lifecycle of the stateful
       bean, which is a convenient approach. The persistence context is closed
       automatically when the stateful EJB is removed.
       
   ■    You can create an EntityManager yourself with the EntityManagerFactory.   
       The persistence context of this EntityManager is application-managed—
       you must flush and close it manually. You also have to use the joinTransac-
       tion() operation to notify the EntityManager if you call it inside JTA trans-
       action boundaries. You’ll almost always prefer the first strategy with stateful
       session beans.


 */
	@PersistenceContext(
			type = PersistenceContextType.EXTENDED,
			properties = @PersistenceProperty(
			              name="org.hibernate.flushMode",
			              value="MANUAL")
	)
	EntityManager em;
	
	@EJB
	ItemDao itemDao;
	
	@EJB
	PaymentDao paymentDao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void doer(){
		
		// use all dao to combine a form a  transaction
		
	}
	
	@Remove
	public void endConversation(){
		
	}
}
