package org.mseco.learning.jsf.api;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class FacesMessageAPI {
	public void execute(ActionEvent ev){
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,"summary","detail");
		
		ctx.addMessage("componenId", fm);
	}
}
