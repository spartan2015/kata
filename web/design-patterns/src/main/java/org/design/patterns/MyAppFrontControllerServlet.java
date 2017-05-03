package org.design.patterns;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAppFrontControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) // template - executed within the context of the container call
			throws ServletException, IOException {
		try {
			Controller controller = ControllerFactory.getController(request); //factory
			String view = controller.execute(new RequestHolderImpl(request), response); // facade RequestHolder, ResponseHolder
			if (view.equals(request.getPathInfo().substring(1))) {
				request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);
			} else {
				response.sendRedirect(view);
			}
		} catch (Exception e) {
			throw new ServletException("Executing Controller failed.", e);
		}

	}
}
