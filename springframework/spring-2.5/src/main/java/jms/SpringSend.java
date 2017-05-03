package jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringSend {
	
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {

		this.jmsTemplate = jmsTemplate;

	}

	private Destination destination;

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public void sendMessage(String text){
		jmsTemplate.send(
				  destination,         
				  new MessageCreator() {
				    public Message createMessage(Session session)                  
				        throws JMSException {
				                       
                        
				    	MapMessage message = session.createMapMessage();
					    message.setString("hello", "World");

				      return message;
				    }
				  });
		
		
	}
	
	
}
