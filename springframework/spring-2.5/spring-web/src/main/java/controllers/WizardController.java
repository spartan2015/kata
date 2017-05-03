package controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

public class WizardController extends AbstractWizardFormController{

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		System.out.println("GET");
		return super.formBackingObject(request);
	}
	
	@Override
	protected void postProcessPage(HttpServletRequest request, Object command,
			Errors errors, int page) throws Exception {
		
		System.out.println("post processing page: " + page);
		
		super.postProcessPage(request, command, errors, page);
	}
	
	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		System.out.println("finish");
		return null;
	}
	
	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		System.out.println("canceled");
		return new ModelAndView(getSuccessView());
	}
	
	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors, int page) throws Exception {
		System.out.println("referenceData for page: " + page);
		return super.referenceData(request, command, errors, page);
	}
	
	// returns the last page as the success view
	private String getSuccessView() {
	  return getPages()[getPages().length-1];
	}
	
	@Override
	protected void validatePage(Object command, Errors errors, int page) {
		System.out.println("validating page: " + page);
		super.validatePage(command, errors, page);
	}


}
