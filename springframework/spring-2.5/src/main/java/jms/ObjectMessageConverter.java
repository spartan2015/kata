package jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class ObjectMessageConverter implements MessageConverter{
	//use with jmsTemplate.convertAndSend(motorist);
	//   jmsTemplate.receiveAndConvert();
	
	public Object fromMessage(Message m) throws JMSException,
			MessageConversionException {
		MapMessage mm = (MapMessage)m;
		
		return mm.getString("hello");
	}

	
	public Message toMessage(Object o, Session s) throws JMSException,
			MessageConversionException {
		String str = (String)o;
		MapMessage m = s.createMapMessage();
		m.setString("hello", str);
		return m;
	}

}
