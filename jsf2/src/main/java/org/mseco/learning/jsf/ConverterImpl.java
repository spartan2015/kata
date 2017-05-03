package org.mseco.learning.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class ConverterImpl implements Converter {
	

	public Object getAsObject(FacesContext ctx, UIComponent comp, String value)
			throws ConverterException {
		String str = "getAsObject converter component: " +  comp + " value: " + value;
		System.out.println(str);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,str,str));
		return value;
	}

	public String getAsString(FacesContext ctx, UIComponent comp, Object value)
			throws ConverterException {
		String str = "getAsString converter component: " +  comp + " value: " + value;
		System.out.println(str);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,str,str));
		return value != null ? value.toString() : null;
	}

}
