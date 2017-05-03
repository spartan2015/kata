package beans.advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.advanced.events.Event;

public class Events {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("events.xml");

		Event event = new Event(new Object(), "event");
		
		ctx.publishEvent(event);
		
		
	}

}
