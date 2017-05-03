package learning.hibernate.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import learning.hibernate.entities.Message;

@Stateless
public class MessageHandlerImpl implements MessageHandler{

	@PersistenceContext
	EntityManager em;
	
	//@Resource(mappedName="java://HelloWorldDS") // works in ejb, ejb listener, servlet, servlet filter, jsf bean
	//DataSource ds;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	//@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	//@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//@TransactionAttribute(TransactionAttributeType.MANDATORY)
	//@TransactionAttribute(TransactionAttributeType.NEVER)
	public void saveMessage(Message message) {
		em.persist(message);
	}

	public void showMessage() {
		List<Message> messages = (List<Message>)em.createQuery("from Message").getResultList();
		for(Message m : messages){
			System.out.println(m.getText());			
		}
	}

}
