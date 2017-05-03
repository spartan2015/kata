package org.mseco.learning.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messages {
	public String action() {

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"info message summary", "info message detail"));

		return null;
	}
}
