package learning.hibernate.app;

import java.util.Iterator;
import java.util.List;

import learning.hibernate.entities.Message;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateHelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Message message = new Message();
		message.setText("hello world");
				
		Long msgId = (Long) session.save(message);
		
		tx.commit();
		session.close();
		
		Session newSession = HibernateUtil.getSessionFactory().openSession();
		Transaction newTx = newSession.beginTransaction();
		
		List messages = newSession.createQuery("from Message").list();
		System.out.println("found: " + messages.size());
		
		for(Iterator it = messages.iterator(); it.hasNext();){
			Message m = (Message)it.next();
			System.out.println("got message: " + m.getText());
		}
		
		newTx.commit();
		newSession.close();

		
		// Third unit of work - Hibernate session check for dirty objects: automatic dirty checking
		Session thirdSession =
		    HibernateUtil.getSessionFactory().openSession();
		Transaction thirdTransaction = thirdSession.beginTransaction();
		// msgId holds the identifier value of the first message
		message = (Message) thirdSession.get( Message.class, msgId );
		message.setText( "Greetings Earthling" );
		message.setNextMessage(
		    new Message( "Take me to your leader (please)" )
		);
		
		// we close the session without explicitly saving the object woooow - this is because session is present- wich is now dirty
		thirdTransaction.commit();
		thirdSession.close();

		
		
		
		HibernateUtil.shutdown();
 
	}

}
