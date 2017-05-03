package org.mseco.learning.hibernate2.polymorphicAssociations.implicit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Long id;
	
	
	private BillingDetails billingDetails;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BillingDetails getBillingDetails() {
		return billingDetails;
	}
	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}	
}
