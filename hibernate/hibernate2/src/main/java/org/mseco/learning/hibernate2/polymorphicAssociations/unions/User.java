package org.mseco.learning.hibernate2.polymorphicAssociations.unions;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy="user") // with a Table Per Concrete Class with unions - you ca nonly map a toMany asociation - the foreign key must be in the BillingDetails
	// it can not be in User because we can NOT represent a foreign key towards two different tables.
	private Set<BillingDetails> billingDetails = new HashSet<BillingDetails>();
	
	public Set<BillingDetails> getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(Set<BillingDetails> billingDetails) {
		this.billingDetails = billingDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

		
}
