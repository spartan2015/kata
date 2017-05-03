package org.mseco.learning.hibernate2.polymorphicAssociations.unions;

import javax.persistence.Entity;

@Entity
public class CreditCard extends BillingDetails{

	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}	
}
