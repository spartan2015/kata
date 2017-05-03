package org.mseco.learning.jsf.projecttrack;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class ArtefactTypeConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str)
			throws ConverterException {
		if (str == null) return null;
		return ArtefactType.valueOf(str);
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj)
			throws ConverterException {
		if (obj == null) return null;
		return ((ArtefactType)obj).name();
	}

}
