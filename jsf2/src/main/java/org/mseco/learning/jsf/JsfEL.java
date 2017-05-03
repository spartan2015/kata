package org.mseco.learning.jsf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsfEL {
	String value = "neo";
	String[] array = {"neo"};
	List list;
	Map map = new HashMap(){
		{put("neo", "neo was here");}
	};
	
	String getString(){
		return "the string";
	}
}
