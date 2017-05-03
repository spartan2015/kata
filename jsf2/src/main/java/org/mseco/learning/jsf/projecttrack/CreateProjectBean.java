package org.mseco.learning.jsf.projecttrack;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectOne;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

public class CreateProjectBean {
	HtmlInputText reqContactEmail;
	UISelectOne projectSelectOne;
	VisitBean visitBean;
	InboxBean inboxBean;
	
	/*
	 * create
	 */
	public String create() {
		System.out.println("create project bean");
		// shoulw create a new project in #{visit.currentProject}
		// either we insert a reference to visit session bean from faces-context xml
		// either ValueBinding - not tried this...
		Project project = new Project();
		project.setName("New project...");
		visitBean.setCurrentProject(project);
		return "create";
	}

	/*
	 * success_readwrite
	 * success_readonly
	 * failure
	 * error
	 */
	public String add(){
		inboxBean.getInboxProjects().add(visitBean.getCurrentProject());		
		return "success_readwrite";
	}
	
	/*
	 * cancel_readwrite
	 * cancel_readonly
	 */
	public String cancel(){
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
	
	public void validateReqContact(FacesContext ctx, UIComponent comp, Object value){
		System.out.println("validateReqContact: " + value);
	}

	public VisitBean getVisitBean() {
		return visitBean;
	}

	public void setVisitBean(VisitBean visitBean) {
		this.visitBean = visitBean;
	}

	public InboxBean getInboxBean() {
		return inboxBean;
	}

	public void setInboxBean(InboxBean inboxBean) {
		this.inboxBean = inboxBean;
	}
	
	
}
