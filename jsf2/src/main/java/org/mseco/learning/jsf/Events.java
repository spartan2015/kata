package org.mseco.learning.jsf;

import javax.faces.FactoryFinder;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelEvent;
import javax.faces.model.DataModelListener;
import javax.faces.model.ListDataModel;

public class Events {
	public void processValueChange(ValueChangeEvent ev){
		System.out.println("old value: " + ev.getOldValue() + " changed to new value: " + ev.getNewValue());
	}
	public void processAction(ActionEvent event){
		System.out.println("processAction");
		
		DataModel dm = new ListDataModel();
		
		dm.addDataModelListener(new DataModelListener(){

			public void rowSelected(DataModelEvent e) {
				System.out.println("row selected: " + e.getRowIndex() );
				
			}
			
		});
		
		addPhaseListener();
	}
	
	public void valueChangeEvent(ValueChangeEvent event){
		String str = "old value: " + event.getOldValue() + " changed to new value: " + event.getNewValue();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,str,str));
		System.out.println(str);
	}
	
	public void actionEvent(ActionEvent event){
		String str = "ActionEvent";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,str,str));
		System.out.println(str);
	}
	
	public void addPhaseListener(){
		LifecycleFactory lf = (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		Lifecycle l = lf.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
		
		l.addPhaseListener(new PhaseListener(){

			public void afterPhase(PhaseEvent e) {
				System.out.println("before: " + e.getPhaseId());
			}

			public void beforePhase(PhaseEvent e) {	
				System.out.println("after: " + e.getPhaseId());
			}

			public PhaseId getPhaseId() {			
				return PhaseId.ANY_PHASE;
			}
			
		});
	}
	
	private HtmlDataTable dataTable;
	
	
	
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
