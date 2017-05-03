package org.mseco.learning.jsf.projecttrack;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class SelectItems {
	private List<SelectItem> artefacts;
	private List<SelectItem> roles;
	private List<SelectItem> projectTypes;
	
	public List<SelectItem> getArtefacts() {
		if (artefacts == null){
			artefacts = new ArrayList<SelectItem>();
			artefacts.add(new SelectItem(ArtefactType.REQUIREMENTS, ArtefactType.REQUIREMENTS.toString()));
			artefacts.add(new SelectItem(ArtefactType.DESIGN, ArtefactType.DESIGN.toString()));
			artefacts.add(new SelectItem(ArtefactType.IMPLEMENTATION, ArtefactType.IMPLEMENTATION.toString()));
			artefacts.add(new SelectItem(ArtefactType.TEST, ArtefactType.TEST.toString()));
		}
		return artefacts;
	}

	public void setArtefacts(List<SelectItem> artefacts) {
		this.artefacts = artefacts;
	}

	public List<SelectItem> getRoles() {
		return roles;
	}

	public void setRoles(List<SelectItem> roles) {
		this.roles = roles;
	}

	public List<SelectItem> getProjectTypes() {
		if (projectTypes == null){
			projectTypes = new ArrayList<SelectItem>();			
			projectTypes.add(new SelectItem(ProjectType.WEB_APPLICATION));
			projectTypes.add(new SelectItem(ProjectType.DESKTOP_APPLICATION));
		}
		return projectTypes;
	}

	public void setProjectTypes(List<SelectItem> projectTypes) {
		this.projectTypes = projectTypes;
	}
}
