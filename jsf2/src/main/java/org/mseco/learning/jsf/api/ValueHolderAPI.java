package org.mseco.learning.jsf.api;

import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;

public class ValueHolderAPI {
	void api() {

		ValueHolder valueHolder = null;

		Object o = valueHolder.getValue();
		valueHolder.setValue(o);

		/*
		 * In section 11.5.1 we talked about how all of the standard component
		 * properties are value-binding enabled. The value property is handled
		 * just like any other—if it has been set by setValue, getValue will
		 * return that value. Otherwise, getValue will check for an associated
		 * ValueBinding instance and return the result of its eval- uation if
		 * found, and null otherwise.
		 */
		// if you don't want to check the valueBinding you can:
		Object o1 = valueHolder.getLocalValue();

		Converter c = valueHolder.getConverter();
		valueHolder.setConverter(c);
		valueHolder.setConverter(FacesContext.getCurrentInstance()
				.getApplication().createConverter(
						DateTimeConverter.CONVERTER_ID));
		
	}
}
