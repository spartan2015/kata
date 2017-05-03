package org.spring.java;

import org.springframework.beans.factory.annotation.Autowired;

public class DefaultHelloWorld implements HelloWorld {

	@Autowired
	private MessageContainer messageContainer;

	public String getMessage() {
		return messageContainer.getMessage();
	}

	public MessageContainer getMessageContainer() {
		return messageContainer;
	}

	public void setMessageContainer(MessageContainer messageContainer) {
		this.messageContainer = messageContainer;
	}

}
