package org.mseco.learning.jsf.projecttrack;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;

public class ShowHistory {
	HtmlDataTable historyDataTable;
	List currentProjectHistory;
	int firstRow;
	int rowsToDisplay;
	
	public String next(){
		// success failure
		return "success";
	}
	
	public String previous(){
		// success faiulre
		return "success";
	}
	
	public boolean showPrevious(){
		return true;		
	}
	
	public boolean showNext(){
		return true;
	}
	
	public String cancel(){
		// cancel_readonly cancel_readwrite
		return "cancel_readwrite";
	}
}
