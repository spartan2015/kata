package org.mseco.learning.jsf.api;

import javax.faces.application.Application;
import javax.faces.component.ActionSource;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class ActionSourceAPI {
	void api(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		Application app = ctx.getApplication();
		
		ActionSource as = new UICommand(); // button or link
		// generates ActionEvent
		
		MethodBinding mb = as.getAction();
		MethodBinding mb1 = as.getActionListener();
		
		ActionListener[] al = as.getActionListeners();
		as.addActionListener(new ActionListener(){
			public void processAction(ActionEvent e) throws AbortProcessingException{
				
			}
		});
		
		MethodBinding mBinding =
			   app.createMethodBinding("myBean.processClaims", new Class[] {} );
			as.setAction(mBinding);
			
		/*
		 *                                                                You can force
JSF to execute the event in the Apply Request Values phase, before validation
even takes place, with the immediate property:
   public boolean isImmediate();
   public void setImmediate(boolean immediate);   

		 */
		as.isImmediate();
		as.setImmediate(true);
		
		
			
	}
}
