package learning.hibernate.app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import learning.hibernate.entities.Message;


public class JpaHelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager session = JpaUtil.getEntityManagerFactory().createEntityManager();
		session.getTransaction().begin();
		
		Message message = new Message();
		message.setText("hello world");
				
		session.persist(message);
		Long msgId = message.getId();
		
		session.getTransaction().commit();
		session.close();
		
		EntityManager newSession = JpaUtil.getEntityManagerFactory().createEntityManager();
		newSession.getTransaction().begin();
		
		List messages = newSession.createQuery("from Message").getResultList();
		System.out.println("found: " + messages.size());
		
		for(Iterator it = messages.iterator(); it.hasNext();){
			Message m = (Message)it.next();
			System.out.println("got message: " + m.getText());
		}
		
		newSession.getTransaction().commit();
		newSession.close();

		
		// Third unit of work - Hibernate session check for dirty objects: automatic dirty checking
		EntityManager thirdSession = JpaUtil.getEntityManagerFactory().createEntityManager();
		thirdSession.getTransaction().begin();
		// msgId holds the identifier value of the first message
		message = (Message) thirdSession.find(Message.class, msgId);
		message.setText( "Greetings Earthling" );
		message.setNextMessage(
		    new Message( "Take me to your leader (please)" )
		);
		
		// we close the session without explicitly saving the object woooow - this is because session is present- wich is now dirty
		thirdSession.getTransaction().commit();
		thirdSession.close();

		
		
		JpaUtil.shutdown();
 
	}

}
