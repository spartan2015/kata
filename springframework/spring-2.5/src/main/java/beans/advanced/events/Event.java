package beans.advanced.events;

import org.springframework.context.ApplicationEvent;

public class Event extends ApplicationEvent{
	private String description;

	public Event(Object source, String description){ // the constructor has a Object "source" passed on.
		super(source); // PAY ATTENTION - THIS MUST BE HERE 
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		return description;
	}

}
