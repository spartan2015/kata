package org.mseco.learning.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class ValueChangeListenerImpl implements ValueChangeListener {

	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {
		
		String str = "ClassListener: old value: " + event.getOldValue() + " changed to new value: " + event.getNewValue();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,str,str));
		System.out.println(str);
		
	}

}
