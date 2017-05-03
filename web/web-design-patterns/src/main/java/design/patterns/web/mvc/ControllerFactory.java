package design.patterns.web.mvc;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

	private static Map<String,Controller> map;
	
	public static synchronized Controller getController(String path){	
		if (map == null){
			map = new HashMap<>();
				 {
					map.put("vehicle/list", new ListController());
					map.put("vehicle/edit", new EditVehicleController());
					map.put("login", new LoginController());
					map.put("logout", new LogoutController());
				}
		}
		
		return map.get(path);		
	}
}
