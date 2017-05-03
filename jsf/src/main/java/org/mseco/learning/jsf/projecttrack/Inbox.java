package org.mseco.learning.jsf.projecttrack;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

public class Inbox {	
	HtmlDataTable projectTable;
	List inboxProjects;
	List allProjects;

	public String approve(){
		// success failure error
		return "success";
	}
	
	public String reject(){
		// success failure error
		return "success";
	}
	
	public void sort(ActionEvent event){
		
	}
	
	public String details(){
		// success failure error
		return "success";
	}
	
	public HtmlDataTable getProjectTable() {
		return projectTable;
	}

	public void setProjectTable(HtmlDataTable projectTable) {
		this.projectTable = projectTable;
	}

	public List getInboxProjects() {
		return inboxProjects;
	}

	public void setInboxProjects(List inboxProjects) {
		this.inboxProjects = inboxProjects;
	}

	public List getAllProjects() {
		return allProjects;
	}

	public void setAllProjects(List allProjects) {
		this.allProjects = allProjects;
	}	
	
	
}
