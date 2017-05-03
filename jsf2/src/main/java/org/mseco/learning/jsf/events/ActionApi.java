package org.mseco.learning.jsf.events;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class ActionApi implements ActionListener{

	/*
	 * 
	 * throwing an AbortProcessingException
	 * aborts processing of the event but doesn’t affect the Request Processing Lifecycle as a whole.
	 * 
	 */
	public void processAction(ActionEvent event) throws AbortProcessingException {
		
		String str = "ActionEvent \nPhaseId: " + event.getPhaseId();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,str,str));
		System.out.println(str);
	
		
		event.processListener(new ActionApi());
		
		boolean b =event.isAppropriateListener(new ActionApi());
		System.out.println("isAppropiateListener: " + b);
		
		event.queue(); // register an event for later broadcasting
		
	}
	
	public String simpleAction(){
		return null;
	}
}
