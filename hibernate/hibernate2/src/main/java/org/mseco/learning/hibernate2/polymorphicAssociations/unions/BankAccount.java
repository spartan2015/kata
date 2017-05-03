package org.mseco.learning.hibernate2.polymorphicAssociations.unions;

import javax.persistence.Entity;

@Entity
public class BankAccount extends BillingDetails{
	private String accountNumber;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
