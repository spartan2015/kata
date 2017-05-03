package org.mseco.learning.jsf;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;

import org.apache.myfaces.component.html.ext.HtmlInputText;

public class ApplicationUsage {

	public String getBundle() {
		Application app = FacesContext.getCurrentInstance().getApplication();
		String messageBundleName = app.getMessageBundle();
		ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, new Locale("ro"));
		
		System.out.println(bundle.getString("applicationName"));
		return null;
	}
	
	public String valueAndMethodBindingExpression(){
		Application app = FacesContext.getCurrentInstance().getApplication();
		ValueBinding vb = app.createValueBinding("#{list}");
		System.out.println(vb.getValue(FacesContext.getCurrentInstance()));
			
		// the last argument are the methods parameters type
		MethodBinding mb = app.createMethodBinding("#{applicationUsage.getBundle}", null);
		
		// the last argumetn is the methods argument list - the actual paramters
		System.out.println("mb" + mb.invoke(FacesContext.getCurrentInstance(), null));
				
		return null;
	}
	
	public String createComponent(){
		Application app = FacesContext.getCurrentInstance().getApplication();
		HtmlInputText t = (HtmlInputText)app.createComponent(HtmlInputText.COMPONENT_TYPE);
		System.out.println(t);
		
		/*
        The componentBinding param-
        eter should point to a backing bean property that returns the proper UI compo-
        nent instance. If the property returns null, this method creates a new instance
        based on the component’s type and uses it to set the backing bean property. 
		 */
		HtmlInputText t1 = (HtmlInputText)app.createComponent(app.createValueBinding("#{list}"),FacesContext.getCurrentInstance(),HtmlInputText.COMPONENT_TYPE);
		System.out.println(t1);
			
		return null;
	}
	
	public String createValidator(){
		Application app = FacesContext.getCurrentInstance().getApplication();
		app.createValidator("myValidator");
		return null;
	}
	
	public String createConvertor(){
		Application app = FacesContext.getCurrentInstance().getApplication();
		app.createConverter("dateConverter");
		return null;
	}
	
	
}
