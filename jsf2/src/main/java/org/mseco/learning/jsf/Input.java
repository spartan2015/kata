package org.mseco.learning.jsf;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

public class Input {
	HtmlInputText inputText;	
	String text;
	
	public HtmlInputText getInputText() {
		return inputText;
	}

	public void setInputText(HtmlInputText inputText) {
		System.out.println("setInputText(HtmlInputText inputText)");
		this.inputText = inputText;
	}

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		System.out.println("setText(String text)");
		this.text = text;
	}

	public void validate(FacesContext ctx, UIComponent comp, Object value){
		System.out.println("public void validate(FacesContext ctx, UIComponent comp, Object value) validatin component: " + comp + " with value: " + value);
	}
}
