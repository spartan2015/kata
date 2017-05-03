package org.mseco.learning.jsf.projecttrack;

import java.util.List;

public class Project {
	private String name;
	
	private ProjectType type;
	
	private StatusType status;
	
	private List<ArtefactType> artefacts;
	
	private List<Operation> history;
	
	private String initialComments;
	
	private String initiatedBy;
	
	private String requirementsContact;
	
	private String requirementsContactEmail;
		
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProjectType getType() {
		return type;
	}
	public void setType(ProjectType type) {
		this.type = type;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public List<ArtefactType> getArtefacts() {
		return artefacts;
	}
	public void setArtefacts(List<ArtefactType> artefacts) {
		this.artefacts = artefacts;
	}
	public List<Operation> getHistory() {
		return history;
	}
	public void setHistory(List<Operation> history) {
		this.history = history;
	}
	public String getInitialComments() {
		return initialComments;
	}
	public void setInitialComments(String initialComments) {
		this.initialComments = initialComments;
	}
	public String getInitiatedBy() {
		return initiatedBy;
	}
	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}
	public String getRequirementsContact() {
		return requirementsContact;
	}
	public void setRequirementsContact(String requirementsContact) {
		this.requirementsContact = requirementsContact;
	}
	public String getRequirementsContactEmail() {
		return requirementsContactEmail;
	}
	public void setRequirementsContactEmail(String requirementsContactEmail) {
		this.requirementsContactEmail = requirementsContactEmail;
	}

}
