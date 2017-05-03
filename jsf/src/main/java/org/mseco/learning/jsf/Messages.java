package org.mseco.learning.jsf;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;


public class Messages {
	Messages() {
		FacesContext.getCurrentInstance().addMessage("message",
				new FacesMessage(FacesMessage.SEVERITY_ERROR , "summary", "detail"));
	}
}
