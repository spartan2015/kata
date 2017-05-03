package org.mseco.learning.jsf.projecttrack;

import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.model.SelectItem;

public class SelectItemToLocaleConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string)
			throws ConverterException {
		System.out.println("SelectItemToLocaleConverter.getAsObject111 " + string);
		if (string == null) {
			return null;
		}
		Locale locale = null;
		try{
			locale = new Locale(string);
		}catch(Exception ex){
			System.out.println("unable to convert from : " + string + " to locale");
			ex.printStackTrace();
		}
		return locale;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object object)
			throws ConverterException {		
		try{
		if (object == null) return null;
		if (!(object instanceof SelectItem)) return null;
		System.out.println("SelectItemToLocaleConverter.getAsString " + ((Locale)object).getLanguage());
		
		return ((Locale)object).getLanguage();
		}catch(Exception ex){
			ex.printStackTrace();			
		}
		return null;
	}

}
