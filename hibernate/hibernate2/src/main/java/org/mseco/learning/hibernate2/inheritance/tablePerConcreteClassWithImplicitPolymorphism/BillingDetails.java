package org.mseco.learning.hibernate2.inheritance.tablePerConcreteClassWithImplicitPolymorphism;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetails {
	
	@Column
	private Date date;
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}	
}
