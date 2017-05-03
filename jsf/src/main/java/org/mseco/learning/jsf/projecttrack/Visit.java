package org.mseco.learning.jsf.projecttrack;

import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.mseco.learning.jsf.projecttrack.entities.Project;
import org.mseco.learning.jsf.projecttrack.entities.User;

public class Visit {
	User user;
	Project currentProject;
	Locale locale;
	List<SelectItem> supportedLocales;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public List<SelectItem> getSupportedLocales() {
		return supportedLocales;
	}
	public void setSupportedLocales(List<SelectItem> supportedLocales) {
		this.supportedLocales = supportedLocales;
	}
	public Project getCurrentProject() {
		return currentProject;
	}
	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}	
}
