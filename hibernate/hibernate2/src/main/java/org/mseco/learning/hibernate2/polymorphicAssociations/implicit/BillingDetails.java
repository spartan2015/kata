package org.mseco.learning.hibernate2.polymorphicAssociations.implicit;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BillingDetails {

	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
