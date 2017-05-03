package org.mseco.learning.jsf;

import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.event.ActionEvent;

public class Hello {
	
	int num;
	HtmlPanelGrid panelGrid;
	
	//@Resource(mappedName="java://HelloWorldDS") // works in ejb, ejb listener, servlet, servlet filter, jsf bean
	//DataSource ds;
	
	public Hello(){
				
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public HtmlPanelGrid getPanelGrid() {
		return panelGrid;
	}
	public void setPanelGrid(HtmlPanelGrid panelGrid) {
		this.panelGrid = panelGrid;
	}
	
	public void redisplay(ActionEvent event){
		System.out.println("redisplay");
		System.out.println(panelGrid);
		if (panelGrid.getChildren() != null){
			panelGrid.getChildren().clear();
		}
		
		
		for(int i = 0; i < num; i++){
			HtmlOutputText outputtext= (HtmlOutputText)FacesContext.getCurrentInstance().getApplication().createComponent(HtmlOutputText.COMPONENT_TYPE);
			outputtext.setValue("" + i);
			panelGrid.getChildren().add(outputtext);
		}
		
	}
	
	public String goodbye(){
		return "goodbye";
	}
}
