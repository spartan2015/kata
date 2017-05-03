package org.mseco.learning.jsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;

public class JsfEl {
	String value = "neo";
	Map<String,String> map = new HashMap<String,String>();
	List<String> list = new ArrayList<String>();
	HtmlInputText inputText;
	
	JsfEl(){
		
		System.out.println("HERE");
		map.put("neo", "can do 1200E/month");
		list.add("neo can make 5000 RON / month");
	}

	public boolean validateMe(){
		return false;
	}
	
	public String methodExecution(){
		return "this was returned by a method execution";
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public HtmlInputText getInputText() {
		return inputText;
	}

	public void setInputText(HtmlInputText inputText) {
		this.inputText = inputText;
	}
	
}
