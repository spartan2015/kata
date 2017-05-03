package org.mseco.learning.jsf.projecttrack;

import java.util.List;

import javax.faces.model.SelectItem;

public class UpdateProject {
	List<SelectItem> comments;
	public String approve(){
		// success_readonly success_readwrite failure error
		return "success_readonly";
	}
	
	public String reject(){
		// success_readonly success_readwrite failure error
		return "success_readonly";
	}
	
	public String cancel(){
		// success_readonly success_readwrite failure error
		return "success_readonly";
	}

	public List<SelectItem> getComments() {
		return comments;
	}

	public void setComments(List<SelectItem> comments) {
		this.comments = comments;
	}
	
	
}
