package org.mseco.learning.jsf.projecttrack;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

public class InboxBean {
	private HtmlDataTable projectTable;
	private List<Project> inboxProjects;
	private List<Project> allProjects;
	private VisitBean visitBean;
	/*
	 * success, failure, error
	 * load a project in visitBean.currentBean returns success if found - else nonfatal error: failure, fatal error: error
	 */
	public String approve(){
		visitBean.setCurrentProject((Project)projectTable.getRowData());
		return "success";
	}
	/*
	 * success, failure, error
	 * load a project in visitBean.currentBean returns success if found - else nonfatal error: failure, fatal error: error
	 */
	public String reject(){
		visitBean.setCurrentProject((Project)projectTable.getRowData());
		return "success";
	}
	/*
	 * success, failure, error
	 * load a project in visitBean.currentBean returns success if found - else nonfatal error: failure, fatal error: error
	 */
	public String details(){
		visitBean.setCurrentProject((Project)getProjectTable().getRowData());
		return "success";
	}
	
	public void sort(ActionEvent event){
		
	}
	public HtmlDataTable getProjectTable() {
		return projectTable;
	}
	public void setProjectTable(HtmlDataTable projectTable) {
		this.projectTable = projectTable;
	}
	public List<Project> getInboxProjects() {
		if (inboxProjects == null){
			inboxProjects = new ArrayList<Project>();
			Project project = new Project();
			project.setName("My new project");
			project.setType(ProjectType.DESKTOP_APPLICATION);
			project.setInitiatedBy("Vasile Irimia");
			project.setRequirementsContact("Vasile IRIMIA");
			project.setRequirementsContactEmail("irimia.vasile@gmail.com");
			project.setStatus(StatusType.INITIAL_PLAN);
			project.setArtefacts(new ArrayList(){
				{ 
					add(ArtefactType.REQUIREMENTS);
					add(ArtefactType.DESIGN);
				}
			});
			
			inboxProjects.add(project);
		}
		return inboxProjects;
	}
	public void setInboxProjects(List<Project> inboxProjects) {
		this.inboxProjects = inboxProjects;
	}
	public List<Project> getAllProjects() {
		return allProjects;
	}
	public void setAllProjects(List<Project> allProjects) {
		this.allProjects = allProjects;
	}
	public VisitBean getVisitBean() {
		return visitBean;
	}
	public void setVisitBean(VisitBean visitBean) {
		this.visitBean = visitBean;
	}
	
	
	
}
