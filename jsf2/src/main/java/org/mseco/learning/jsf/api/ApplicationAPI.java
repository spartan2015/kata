package org.mseco.learning.jsf.api;

import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;

import org.apache.myfaces.component.html.ext.HtmlInputText;
import org.mseco.learning.jsf.ConverterImpl;
import org.mseco.learning.jsf.Events;

public class ApplicationAPI {
	ApplicationAPI(){
		
		/*
		 * this is the web application
		 * access global resources
		 * with value- and method- binding you get to the managed beans
		 * factory methods for creating components, converters, validators
		 * locale access
		 * render kit
		 * 
		 */
		Application application = FacesContext.getCurrentInstance().getApplication();
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		Locale locale = application.getDefaultLocale();
		application.setDefaultLocale(Locale.ENGLISH);
		Iterator<Locale> it = application.getSupportedLocales();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		ValueBinding vb = application.createValueBinding("#{events}");
		Events events = (Events)vb.getValue(FacesContext.getCurrentInstance());
		vb.setValue(ctx, "neo");
		Class c = vb.getType(ctx);
		System.out.println(events);
		
		// execute a method
		MethodBinding mb = application.createMethodBinding("#{bean.getName}", new Class[]{}); 
		Object o = mb.invoke(ctx, new Object[0]);
		c = mb.getType(ctx);
		
		//  message bundle
		String messageBundle = application.getMessageBundle();
		ResourceBundle bundle = ResourceBundle.getBundle(messageBundle,Locale.ENGLISH);
		
		// render kit
		String renderKit = application.getDefaultRenderKitId();
		System.out.println(renderKit);
		
		
		// create component
		/*
		 * The first method is simple—it just creates a new UI component based on its type.
What is its type? Basically, it’s an identifier the component was given in a JSF
configuration file; you can map this identifier to a specific class name. For exam-
ple, you could register the class name com.my.SillyComponent with the type “Silly-
Component”.

		 */
		HtmlInputText txt = (HtmlInputText)application.createComponent(HtmlInputText.COMPONENT_TYPE);
		System.out.println("txt");
		
		
		// create validator - only for EditableValueHolder (s)
		application.createValidator("validatorId"); // configured in faces-context
		
		// create converter - only for ValueHolder (s)
		application.createConverter("converterId"); //configured in faces-context
		application.createConverter(org.mseco.learning.jsf.ConverterImpl.class);
		
		
	}
}
