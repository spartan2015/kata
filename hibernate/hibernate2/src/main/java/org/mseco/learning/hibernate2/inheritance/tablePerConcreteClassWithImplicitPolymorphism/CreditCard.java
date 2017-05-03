package org.mseco.learning.hibernate2.inheritance.tablePerConcreteClassWithImplicitPolymorphism;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CreditCard extends BillingDetails{
	@Id
	private Long id;	
	private Integer cardNumber;
	@Temporal(TemporalType.DATE)
	private Date expDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}	
}
