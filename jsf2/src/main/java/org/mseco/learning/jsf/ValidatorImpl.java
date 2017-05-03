package org.mseco.learning.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidatorImpl implements Validator{

	public void validate(FacesContext ctx, UIComponent comp, Object obj)
			throws ValidatorException {
		
		String str = "ValidatorImpl.validate(FacesContext ctx, UIComponent comp, Object obj)";
						
		System.out.println(str);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,str,str));
	}

}
