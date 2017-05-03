package org.mseco.learning.jsf.api;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import org.apache.myfaces.component.html.ext.HtmlInputText;

public class UIComponentAPI {
	
	UIComponent component;
	
	void api(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		Application app = ctx.getApplication();
		
		String id = component.getId();
		component.setId("theid223333");
		component.getAttributes().get("id");
		
		HtmlInputText hit = (HtmlInputText)FacesContext.getCurrentInstance()
			.getApplication().createComponent(HtmlInputText.COMPONENT_TYPE);
		
		/*
		 *    Attributes are used by converters, renderers, and validators when they need
configuration values that are associated with a specific component.

		you can’t call remove, and containsKey always returns false.
		 */
		Map attributes = component.getAttributes();
		component.getAttributes().put("cellpadding", "0");
		
		/*
		 	This is equivalent to the following JSP snippet:
  				<h:inputText value="#{myBean.userName}"
                			 title="#{myBundle.userNameTitle}"/>
		 */
		component.setValueBinding("value", app.createValueBinding("#{bean}"));
		ValueBinding vb = component.getValueBinding("title");
		
		//visibility
		component.isRendered();
		component.setRendered(true);
		
		// Composite pattern [GangOfFour - GoF]
		UIComponent p = component.getParent();
		List<UIComponent> list = component.getChildren();
		int i = component.getChildCount();
		UIComponent c = component.findComponent("the id");
		
		// facets 
		Map facets = component.getFacets();
		UIComponent facet = component.getFacet("header");
		Iterator facestsAndChildren = component.getFacetsAndChildren();
		
		
		
		
		
	}
	
}
