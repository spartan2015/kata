package org.mseco.learning.jsf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

public class UserForm {
	String name;
	Boolean check;
	SelectItem selectItem;
	List<SelectItem> selectItems;
	DataModel simpleList;
	List<String> stringList;
	String[] strings;
	HtmlDataTable dataTable;
	Date date = new Date();
	double doubleNumber;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void nameChange(ValueChangeEvent event) {
		String s = "old value: " + event.getOldValue() + ", new value: "
				+ event.getNewValue();
		FacesContext.getCurrentInstance().addMessage(s,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, s, s));
		FacesContext.getCurrentInstance().addMessage(s,
				new FacesMessage(FacesMessage.SEVERITY_INFO, s, s));
		FacesContext.getCurrentInstance().addMessage(s,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, s, s));
		FacesContext.getCurrentInstance().addMessage(s,
				new FacesMessage(FacesMessage.SEVERITY_WARN, s, s));
		System.out.println(s);

	}

	public void actionListener(ActionEvent event) {
		System.out.println("actionListener");
	}

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public SelectItem getSelectItem() {
		if (selectItem == null) {
			selectItem = new SelectItem();
			selectItem.setLabel("label-coded");
			selectItem.setValue("value-coded");
		}
		return selectItem;
	}

	public void setSelectItem(SelectItem selectItem) {
		this.selectItem = selectItem;
	}

	public List<SelectItem> getSelectItems() {
		if (selectItems == null) {
			selectItems = new ArrayList<SelectItem>();
			for (int i = 0; i < 5; i++) {
				SelectItem item = new SelectItem();
				item.setLabel("for label " + i);
				item.setValue("for value " + i);
				selectItems.add(item);
			}

			// we'll put a group in it just for fun
			SelectItemGroup sig = new SelectItemGroup();
			sig.setLabel("groupLabel");
			sig.setValue("groupValues");

			SelectItem[] selectItemsList = new SelectItem[4];
			for (int i = 0; i < 4; i++) {
				SelectItem item = new SelectItem();
				item.setLabel("for label " + i);
				item.setValue("for value " + i);
				selectItemsList[i] = item;
			}

			sig.setSelectItems(selectItemsList);

			selectItems.add(sig);
		}
		return selectItems;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}

	public DataModel getSimpleList() {
		System.out.println("here");
		if (simpleList == null) {
			List<String> list = new ArrayList<String>();
			list.add("power");
			list.add("mastery");
			list.add("composure");
			list.add("expertise");
			simpleList = new ListDataModel(list);
		}
		System.out.println("getSimpleList" + simpleList);
		return simpleList;
	}

	public void setSimpleList(DataModel simpleList) {
		this.simpleList = simpleList;
	}

	public List<String> getStringList() {
		if (stringList == null){
			stringList = new ArrayList<String>();
			stringList.add("11");
			stringList.add("22");
		}
		return stringList;
	}

	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}

	public String[] getStrings() {
		if (strings == null){
			strings = new String[]{"11","22","33"};
		}
		
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}


	public void deleteFromSimpleListActionListener(ActionEvent event){
		System.out.println("deleteFromSimpleListActionListener");
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getDoubleNumber() {
		return doubleNumber;
	}

	public void setDoubleNumber(double doubleNumber) {
		this.doubleNumber = doubleNumber;
	}
	
}
