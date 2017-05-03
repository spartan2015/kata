package org.mseco.learning.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

public class Checkbox {
	Boolean checkbox;

	List<SelectItem> selectedListOfSelectItem = new ArrayList<SelectItem>();

	SelectItem selectedItem;

	SelectItem selectItem = new SelectItem("value", "label", "description");

	List<SelectItem> selectItems = new ArrayList<SelectItem>();

	String selectOneResult;
	
	public Boolean getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(Boolean checkbox) {
		this.checkbox = checkbox;
	}

	public List<SelectItem> getSelectedListOfSelectItem() {
		return selectedListOfSelectItem;
	}

	public void setSelectedListOfSelectItem(
			List<SelectItem> selectedListOfSelectItem) {
		System.out.println("setSelectedListOfSelectItem: "
				+ selectedListOfSelectItem);
		this.selectedListOfSelectItem = selectedListOfSelectItem;
	}

	public SelectItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(SelectItem selectedItem) {
		System.out.println("setSelectedItem(SelectItem selectedItem): "
				+ selectedItem);
		this.selectedItem = selectedItem;
	}

	public SelectItem getSelectItem() {
		return selectItem;
	}

	public void setSelectItem(SelectItem selectItem) {
		this.selectItem = selectItem;
	}
	
		
	
	public String getSelectOneResult() {
		return selectOneResult;
	}

	public void setSelectOneResult(String selectOneResult) {
		this.selectOneResult = selectOneResult;
	}

	public List<SelectItem> getSelectItems() {
		selectItems.clear();
		for (int i = 0; i < 10; i++) {
			selectItems.add(new SelectItem("value " + i, "label " + i));
		}
		SelectItemGroup g = new SelectItemGroup();
		g.setLabel("Group");
		g.setValue("group value");

		g.setSelectItems(new SelectItem[] {
				new SelectItem("subItem1", "subItem1"),
				new SelectItem("subItem2", "subItem2") });

		selectItems.add(g);
		return selectItems;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}

}
