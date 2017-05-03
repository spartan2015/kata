package org.mseco.learning.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class ActionEventImpl implements ActionListener {

	public void processAction(ActionEvent event) throws AbortProcessingException {
		String str = "ActionEvent";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,str,str));
		System.out.println(str);
		
	}

}
