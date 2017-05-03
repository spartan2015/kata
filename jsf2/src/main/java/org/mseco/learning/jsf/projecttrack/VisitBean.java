package org.mseco.learning.jsf.projecttrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class VisitBean {
	private User user;
	private Project currentProject;
	private Locale locale;
	private List<SelectItem> supportedLocales;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Project getCurrentProject() {
		return currentProject;
	}
	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}
	public Locale getLocale() {
		if (locale != null)
			System.out.println("get locale: " + locale.getLanguage());
		else
			System.out.println("get locale: null");
		return locale;
	}
	public void setLocale(Locale locale) {
		System.out.println("setLocale(" + locale.toString());
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		this.locale = locale;
	}
	public List<SelectItem> getSupportedLocales() {
		if (supportedLocales == null){
			supportedLocales = new ArrayList<SelectItem>();
			supportedLocales.add(new SelectItem(new Locale("romanian"),"romanian"));
			supportedLocales.add(new SelectItem(Locale.ENGLISH,"english"));
		}
		return supportedLocales;
	}
	public void setSupportedLocales(List<SelectItem> supportedLocales) {
		this.supportedLocales = supportedLocales;
	}		
}
