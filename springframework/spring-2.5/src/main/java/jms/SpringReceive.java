package jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;

public class SpringReceive {

	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {

		this.jmsTemplate = jmsTemplate;

	}

	private Destination destination;

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public String receiveMessage(){
        
		MapMessage message = (MapMessage) jmsTemplate.receive(destination);
	
		String result = null;
		try { 
			
			result = message.getString("hello");
			
	} catch (JMSException e) {
		  throw JmsUtils.convertJmsAccessException(e);
		}

		return result; 
	}
	
}
