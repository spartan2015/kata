package tilecontrollers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.tiles.ComponentContext;
import org.springframework.web.servlet.view.tiles.ComponentControllerSupport;

import controllers.FormController;

public class HeaderTileController extends ComponentControllerSupport {
	public HeaderTileController() {
	}

	protected void doPerform(ComponentContext componentContext,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	  
	  
	  componentContext.putAttribute("springAttribute", "asd");
	}

	private FormController getRantService() {
		return (FormController) getApplicationContext().getBean("formController");
	}

}
