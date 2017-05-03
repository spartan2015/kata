package org.mseco.learning.jsf.projecttrack;

import java.util.Date;

public class Operation {
	private Date timestamp;
	private StatusType toStatus;
	private User user;
	private String comments;
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public StatusType getToStatus() {
		return toStatus;
	}
	public void setToStatus(StatusType toStatus) {
		this.toStatus = toStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}	
}
