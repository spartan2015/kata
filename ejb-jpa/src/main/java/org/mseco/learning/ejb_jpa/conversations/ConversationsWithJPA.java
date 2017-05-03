package org.mseco.learning.ejb_jpa.conversations;

/*
 *   You want to propagate the persistence context so that one persistence con-
  text is used for all data access in a particular request. In Hibernate, this
  functionality is built in with the getCurrentSession() feature. 
  
  JPA doesn’t  have this feature if it’s deployed stand-alone in Java SE. 
  
  On the other hand,  
  thanks to the EJB 3.0 programming model and the well-defined scope and
  lifecycle of transactions and managed components, JPA in combination with
  EJBs is much more powerful than native Hibernate.


  If you decide to use a detached objects approach as your conversation
  implementation strategy, you need to make changes to detached objects
  persistent. Hibernate offers reattachment and merging; JPA only supports
  merging. We discussed the differences in the previous chapter in detail, but
  we want to revisit it briefly with more realistic conversation examples.


  If you decide to use the session-per-conversation approach as your conversa-
  tion implementation strategy, you need to extend the persistence context to
  span a whole conversation. We look at the JPA persistence context scopes
  and explore how you can implement extended persistence contexts with
  JPA in Java SE and with EJB components.


 */
public class ConversationsWithJPA {

}
