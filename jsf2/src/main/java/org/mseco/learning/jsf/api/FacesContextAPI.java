package org.mseco.learning.jsf.api;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.event.ActionEvent;

public class FacesContextAPI {
	
	public void execute(ActionEvent event){
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		
		Iterator<FacesMessage> messages = ctx.getMessages();
		while(messages.hasNext()){
			System.out.println(messages.next());
		}
		
		Iterator<FacesMessage> messages1 = ctx.getMessages("componentId");
		while(messages1.hasNext()){
			System.out.println(messages1.next());
		}
		
		FacesMessage.Severity ms = ctx.getMaximumSeverity();
		
		
		// the view root
		UIViewRoot root = ctx.getViewRoot();
		ctx.setViewRoot(root);
		
		// control the request lifecycle:
		//ctx.renderResponse(); // jump to the render phase
		//ctx.responseComplete(); // use this if you already sent the response and you need no other rendering: skips rendering phase
		ResponseStream rs = ctx.getResponseStream(); // return binary data(maybe an image)
		ResponseWriter rw = ctx.getResponseWriter(); // return text
		// after using this methods you MUST CALL ctx.responseComplete();
		
		
		
		
		
		ExternalContext ectx = ctx.getExternalContext();
			
		
		/*
        Do not access FacesContext from any thread other than the one servic-
        ing the request. In other words, don’t spawn a new thread and try to use
        a FacesContext instance—this behavior is not supported.
		 */
		
		
	}
}
