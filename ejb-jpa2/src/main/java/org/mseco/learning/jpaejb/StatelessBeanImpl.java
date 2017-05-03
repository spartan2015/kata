package org.mseco.learning.jpaejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.hibernate.Session;

@Stateless
public class StatelessBeanImpl implements StatelessBean{

	@PersistenceContext(unitName="helloworld")
	EntityManager em;
	
	@PersistenceContext(unitName="helloworld") // you can use multiple persistence units
	EntityManager em2;
	
	@PersistenceContext
	Session session;
	
//	@PersistenceContext
//	public void setEntityManager(EntityManager em){
//		this.em = emp;
//	}
	
	@Resource(mappedName="java:/HelloWorldDS") 
	DataSource ds; // this gives you direct jdbc
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED) // this is default - so you could skip this
	public void doATransaction(){
		Message m = new Message();
		m.setText("stateless ejb message");
		em.persist(m);
		
		List<Message> messages = (List<Message>)em.createQuery("select m from Message m").getResultList();
		for(Message message : messages){
			System.out.println("message: " + message.getText());
		}
	}
}
