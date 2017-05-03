package springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class DefaultHelloWorld implements HelloWorld {

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
