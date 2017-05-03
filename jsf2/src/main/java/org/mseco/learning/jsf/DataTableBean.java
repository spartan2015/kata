package org.mseco.learning.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class DataTableBean {
	HtmlDataTable dataTable;
	
	List<User> users = new ArrayList<User>(){
		{
			add(new User("my","looking for a job for a phd student"));
			add(new User("my1","looking for a job for a phd student1"));
		}
	};
	
	
	
	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public HtmlDataTable getDataTable() {
		return dataTable;
	}



	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}



	public void deleteRow(ActionEvent event){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"deleteRow action","deleteRow action"));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"dataTable.isRowAvailable(): " +dataTable.isRowAvailable(),"" +dataTable.isRowAvailable()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"dataTable.getRowIndex(): " +dataTable.getRowIndex(),"" +dataTable.getRowIndex()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"dataTable.getRowData(): " +dataTable.getRowData(),"" +dataTable.getRowData()));		
	}
}
