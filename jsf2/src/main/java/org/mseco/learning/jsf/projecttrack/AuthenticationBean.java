package org.mseco.learning.jsf.projecttrack;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class AuthenticationBean {
	private String loginName;
	private String password;
	boolean createNewAuthorized;
	boolean inboxAuthorized;
		
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	/*
	 * success_readwrite
	 * success_readonly
	 * failure 
	 */
	public String login(){
		setCreateNewAuthorized(true);
		setInboxAuthorized(true);
		System.out.println("success_readwrite");
		return "success_readwrite";
	}
	
	/*
	 * success
	 */
	public String logout(){
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session != null){
			session.invalidate();
		}
		return "success";
	}
}
