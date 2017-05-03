package org.mseco.learning.hibernate2.inheritance.tablePerSubclass;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name="CreditCard_id")
public class CreditCard extends BillingDetails{
	
	private Integer cardNumber;
	@Temporal(TemporalType.DATE)
	private Date expDate;
	
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
