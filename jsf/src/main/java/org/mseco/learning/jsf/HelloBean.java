package org.mseco.learning.jsf;

import java.util.Date;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class HelloBean {
	private Long numControls;
	private HtmlPanelGrid controlPanel;
	private Date date = new Date();
	
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getNumControls() {
		return numControls;
	}

	public void setNumControls(Long numControls) {
		this.numControls = numControls;
	}

	public HtmlPanelGrid getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(HtmlPanelGrid controlPanel) {
		this.controlPanel = controlPanel;
	}

	public String goodbye() {
		return "success";
	}
	
	public void addControls(ActionEvent event){
		Application app = FacesContext.getCurrentInstance().getApplication();
		
		List children = controlPanel.getChildren();
		children.clear();
		for(int i = 0; i < numControls; ++i){
			HtmlOutputText output = (HtmlOutputText)app.createComponent(HtmlOutputText.COMPONENT_TYPE);
			output.setValue(i);
			output.setStyle("color:blue");
			children.add(output);
			
		}
	} 
}
