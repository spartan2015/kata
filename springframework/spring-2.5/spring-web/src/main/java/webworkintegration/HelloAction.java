package webworkintegration;

import com.opensymphony.xwork.Action;

public class HelloAction implements Action {

	private String hello;
	
	public String execute() throws Exception {
		
		hello = "world";
		
		return "SUCCESS";
	}

}
