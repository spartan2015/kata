package org.mseco.learning.jsf.events;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class ValueChangeApi implements ValueChangeListener{

	/*
	 * 
	 * throwing an AbortProcessingException
	 * aborts processing of the event but doesn’t affect the Request Processing Lifecycle as a whole.
	 * 
	 */
	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {
		
		
		String str = "processValueChange - old value: " + event.getOldValue() + ", new value: " + event.getNewValue(); 
		str += "PhaseId: " + event.getPhaseId();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,str,str));
		System.out.println(str);
		
	}

}
