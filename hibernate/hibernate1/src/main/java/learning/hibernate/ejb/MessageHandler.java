package learning.hibernate.ejb;

import learning.hibernate.entities.Message;

public interface MessageHandler {
	void showMessage();
	void saveMessage(Message message);
}
