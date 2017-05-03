package jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class MessageListenerImpl implements MessageListener{


	public void onMessage(Message message) {
		
		MapMessage mapMessage = (MapMessage) message;
		
		try {
			System.out.println("Got message: " + mapMessage.getString("hello"));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
