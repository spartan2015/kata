package org.mseco.learning.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelEvent;
import javax.faces.model.DataModelListener;
import javax.faces.model.ListDataModel;

public class MyForm {

	private HtmlPanelGrid panelGrid;
	private String change = "";
	private HtmlDataTable dataTable;

	public MyForm() {
		/*
		 * REQUEST LIFE CYCLE
		 * 1. restore the view
		 * 2. get parameters
		 * 3. validate
		 * 4. bind to backing bean
		 * 5. action listener
		 */		
		
	}

	private DataModel dataModel;

	public DataModel getDataModel() {
		List<String> list = new ArrayList<String>();
		list.add("Romania");
		list.add("United Kindom");

		DataModel dm = new ListDataModel(list);

		/*
		 * The result is that every time an HtmlDataTable iterates through a new
		 * row in the data model, our listener will be executed. Usually this
		 * happens when the component is being displayed. Since data model
		 * events are fired so many times, they’re normally used when developing
		 * a data-driven component, rather than during application development.
		 */
		dm.addDataModelListener(new DataModelListener() {
			public void rowSelected(DataModelEvent e) {
				System.out.println("Row changed: " + e.getRowIndex());
			}
		});
		/*
		 * Array List Result ResultSet Scalar
		 */
		return dm;

	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public HtmlPanelGrid getPanelGrid() {
		return panelGrid;
	}

	public void setPanelGrid(HtmlPanelGrid panelGrid) {
		this.panelGrid = panelGrid;
	}

	public void processValueChanged(ValueChangeEvent event) {
		System.out.println("changed");
		change = "old value was: " + event.getOldValue() + ", new values is: "
				+ event.getNewValue();
		System.out.println(change);

		System.out.println(panelGrid);
		panelGrid.setTitle(change);

		HtmlInputText sender = (HtmlInputText) event.getComponent();
		sender.setReadonly(false);
		panelGrid.setRendered(true);

	}

	public String navigateHello() {
		return "hello";
	}

	public String navigateDate() {
		return "date";
	}

	public void sayHello(ActionEvent event) {
		System.out.println("ActionEvent");
	}
}
