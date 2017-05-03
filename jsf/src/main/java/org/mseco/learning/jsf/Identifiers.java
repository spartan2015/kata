package org.mseco.learning.jsf;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ActionEvent;

public class Identifiers {
	public void processActionEvent(ActionEvent event){
		HtmlOutputText h = (HtmlOutputText)event.getComponent().findComponent("myForm:text");
		
		h.setValue("Who is the man ???");
		h.setStyle("color:red");
		
	}
}
