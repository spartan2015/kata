package org.mseco.learning.jsf.projecttrack;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectOne;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

public class CreateProject {

	HtmlInputText reqContactEmail;
	UISelectOne projectSelectOne;
	
	public void validateReqContact(FacesContext ctx, UIComponent component, Object object){
		
	}
		
	public String add(){
		// success_readonly success_readwrite failure error
		return "success_readwrite";
	}
	
	public String create(){		
		return "success";
	}
	
	public String cancel(){
		// cancel_readonly cancel_readwrite
		return "cancel_readwrite";
	}

	public HtmlInputText getReqContactEmail() {
		return reqContactEmail;
	}

	public void setReqContactEmail(HtmlInputText reqContactEmail) {
		this.reqContactEmail = reqContactEmail;
	}

	public UISelectOne getProjectSelectOne() {
		return projectSelectOne;
	}

	public void setProjectSelectOne(UISelectOne projectSelectOne) {
		this.projectSelectOne = projectSelectOne;
	}	
}
