package org.design.patterns;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ControllerFactory {
	
	static Map<String,Controller> controllersRegistry = new HashMap(); // singleton out of this
	{
		// created manually, reading from xml, scanning the classpath for markers like annotations or interfaces
		controllersRegistry.put("POST/register", new RegisterController());
		controllersRegistry.put("POST/login", new LoginController());
		controllersRegistry.put("GET/logout", new LogoutController());
	}
	
	static Controller getController(HttpServletRequest request) {
		return controllersRegistry.get(request.getPathInfo());
	}
}