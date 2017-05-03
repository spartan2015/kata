package org.mseco.learning.hibernate2.inheritance.mixtablePerHierachyWithTablePerSubclass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name="BankAccount")
public class BankAccount extends BillingDetails{
	
	@Column(table="BankAccount") // !!!!!!!!!!!!!!!! we move these columns into the secondary table !!!!!!!!
	private String iban;
	@Column(table="BankAccount")
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
