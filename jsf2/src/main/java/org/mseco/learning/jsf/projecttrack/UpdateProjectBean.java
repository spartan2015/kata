package org.mseco.learning.jsf.projecttrack;


public class UpdateProjectBean {
	private String comments;
	
	/*
	 * success_readwrite
	 * success_readonly
	 * failure
	 * error
	 * 
	 * approves the project, moves it to  the next status, updates history adding a new approval Operation
	 */
	public String approve(){
		return "success_readwrite";
	}
	
	/*
	 * success_readonly
	 * success_readwrite
	 * cancel_readonly
	 * cancel_readwrite
	 * 
	 * failure
	 * error
	 * 
	 * rejects a project moving it to a previous status
	 */
	public String reject(){
		return "success_readwrite";
	}
	
	/*
	 * 
	 * cancel_readonly
	 * cancel_readwrite
	 * 
	 * 
	 */
	public String cancel(){
		return "cancel_readwrite";
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
