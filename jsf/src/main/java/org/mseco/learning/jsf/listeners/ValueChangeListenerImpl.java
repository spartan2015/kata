package org.mseco.learning.jsf.listeners;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class ValueChangeListenerImpl implements ValueChangeListener{

	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {
		String s= "old value: " + event.getOldValue() + ", new value: " + event.getNewValue();
		FacesContext.getCurrentInstance().addMessage(s, new FacesMessage(FacesMessage.SEVERITY_ERROR,s,s));
		FacesContext.getCurrentInstance().addMessage(s, new FacesMessage(FacesMessage.SEVERITY_INFO,s,s));
		FacesContext.getCurrentInstance().addMessage(s, new FacesMessage(FacesMessage.SEVERITY_FATAL,s,s));
		FacesContext.getCurrentInstance().addMessage(s, new FacesMessage(FacesMessage.SEVERITY_WARN,s,s));
		System.out.println("+" +s);
	}
}
