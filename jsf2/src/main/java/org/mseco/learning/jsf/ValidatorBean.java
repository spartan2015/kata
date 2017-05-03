package org.mseco.learning.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class ValidatorBean {
	public void validateValue(FacesContext ctx, UIComponent component, Object value){
		System.out.println("validateValue(FacesContext ctx, UIComponent component, Object value) : " + value );	
	}
}
