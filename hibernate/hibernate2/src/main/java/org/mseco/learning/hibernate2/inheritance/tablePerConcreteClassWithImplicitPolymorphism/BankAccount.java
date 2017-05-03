package org.mseco.learning.hibernate2.inheritance.tablePerConcreteClassWithImplicitPolymorphism;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount extends BillingDetails{
	@Id
	private Long id;
	private String iban;
	private String currency;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
