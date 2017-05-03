package beans.advanced.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EventListener implements ApplicationListener{

	public void onApplicationEvent(ApplicationEvent event) {		
		System.out.println("event received: " + event.toString());
	}

	
}
