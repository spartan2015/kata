package org.mseco.learning.jsf.projecttrack;

import java.util.List;

import javax.faces.model.SelectItem;

public class SelectItems {
	List<SelectItem> artifacts;
	List<SelectItem> roles;
	List<SelectItem> projectTypes;

	public List<SelectItem> getArtifacts() {
		return artifacts;
	}

	public void setArtifacts(List<SelectItem> artifacts) {
		this.artifacts = artifacts;
	}

	public List<SelectItem> getRoles() {
		return roles;
	}

	public void setRoles(List<SelectItem> roles) {
		this.roles = roles;
	}

	public List<SelectItem> getProjectTypes() {
		return projectTypes;
	}

	public void setProjectTypes(List<SelectItem> projectTypes) {
		this.projectTypes = projectTypes;
	}		
}
