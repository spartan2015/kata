package org.mseco.learning.jsf.projecttrack;

public class Authentication {
	String user;
	String password;
	boolean createNewAuthorized;
	boolean inboxAuthorized;
	
	public String login(){
		//"success_readwrite"
		//"failure"
		return "success_readonly";
	}
	
	public String logout(){
		return "success";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCreateNewAuthorized() {
		return createNewAuthorized;
	}

	public void setCreateNewAuthorized(boolean createNewAuthorized) {
		this.createNewAuthorized = createNewAuthorized;
	}

	public boolean isInboxAuthorized() {
		return inboxAuthorized;
	}

	public void setInboxAuthorized(boolean inboxAuthorized) {
		this.inboxAuthorized = inboxAuthorized;
	}
	
	
}
