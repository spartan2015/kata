package org.mseco.learning.hibernate2.inheritance.tablePerSubclass;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="BankAccount_id")
public class BankAccount extends BillingDetails{

	
	
	private String iban;
	private String currency;
	
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
