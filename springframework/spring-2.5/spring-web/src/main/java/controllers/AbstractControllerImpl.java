package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class AbstractControllerImpl extends AbstractController{

	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return new ModelAndView(getView(request));
	}
	
	private String getView(HttpServletRequest req){
		String url = req.getRequestURL().toString();
		//System.err.println(url);
		if (url.substring(url.lastIndexOf(".")+1).equals("xls")){
			return "excel.xls";
		}else if(url.substring(url.lastIndexOf(".")+1).equals("pdf")){
			return "pdf.pdf";
		}else if(url.substring(url.lastIndexOf(".")+1).equals("rss")){
			return "rss.rss";
		}
		else{
			return "home";
		}
	}

}
