package controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import edu.emory.mathcs.backport.java.util.Arrays;

public class FormController extends SimpleFormController{
	
	// on GET
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		System.out.println("GET");		
		return super.formBackingObject(request);
	}
	
	// on submit - POST
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		System.out.println("POST");
		return super.onSubmit(request, response, command, errors);
	}
	
	
	//setup data used in the view, after POST
	protected Map referenceData(HttpServletRequest request) throws Exception {
		System.out.println("Setup reference data");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("selects", Arrays.asList(new String[]{"Africa","America","Asia"}));
		return super.referenceData(request);
	}

}
