package design.patterns.web.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyWebApplication extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			Controller controller = ControllerFactory.getController(request.getPathInfo());
			if (controller == null){
				throw new ControllerNotFoundException();
			}
			
			String view = controller.execute(request,response);
			
			
			request.getRequestDispatcher(view).forward(request, response);
			
		}catch(Exception ex){
			System.out.println();
			request.getRequestDispatcher("error").forward(request, response);
		}
		
	}
	
}
