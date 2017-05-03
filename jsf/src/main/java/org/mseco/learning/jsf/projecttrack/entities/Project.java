package org.mseco.learning.jsf.projecttrack.entities;

import java.util.List;

public class Project {
	List<ArtifactType> artifacts;
	List<Operation> history;
	String initialComments;
	String initiatedBy;
	String name;
	String requirementsContact;
	String requirementsContactEmail;
	StatusType status;
	ProjectType type;
	
	public List<ArtifactType> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<ArtifactType> artifacts) {
		this.artifacts = artifacts;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public ProjectType getType() {
		return type;
	}
	public void setType(ProjectType type) {
		this.type = type;
	}		
}
