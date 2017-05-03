package org.mseco.learning.jsf.listeners;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class ActionListenerImpl implements ActionListener {

	public void processAction(ActionEvent event) throws AbortProcessingException {
		System.out.println("processAction");
	}
}
