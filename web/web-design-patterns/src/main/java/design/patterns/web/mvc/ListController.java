package design.patterns.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import design.patterns.web.services.VehicleService;

public class ListController implements Controller {

	VehicleService service = VehicleService.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("list", service.findAll());
		
		return "list";
	}

}
