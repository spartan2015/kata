package org.mseco.learning.jsf.projecttrack;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;

public class ShowHistoryBean {
	private HtmlDataTable historyDataTable;
	List<Operation> currentProjectHistory;	
	private int firstRow = 0;
	private int rowsToDisplay = 10;
	
	public boolean getShowPrevious(){
		return true;
	}
	public boolean getShowNext(){
		return true;
	}
	/*
	 * success
	 * failure
	 */
	public String next(){
		return "success";
	}
	
	/*
	 * success
	 * failure
	 */
	public String previous(){
		return "success";
	}
	
	/*
	 * cancel_readonly
	 * cancel_readwrite
	 */
	public String cancel(){
		return "cancel_readwrite";
	}
	
	public HtmlDataTable getHistoryDataTable() {
		return historyDataTable;
	}

	public void setHistoryDataTable(HtmlDataTable historyDataTable) {
		this.historyDataTable = historyDataTable;
	}

	public List<Operation> getCurrentProjectHistory() {
		return currentProjectHistory;
	}

	public void setCurrentProjectHistory(List<Operation> currentProjectHistory) {
		this.currentProjectHistory = currentProjectHistory;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getRowsToDisplay() {
		return rowsToDisplay;
	}

	public void setRowsToDisplay(int rowsToDisplay) {
		this.rowsToDisplay = rowsToDisplay;
	}
	
	
	
}
