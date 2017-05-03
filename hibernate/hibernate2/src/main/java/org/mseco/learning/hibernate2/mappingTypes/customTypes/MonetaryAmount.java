package org.mseco.learning.hibernate2.mappingTypes.customTypes;

import java.math.BigDecimal;
import java.util.Currency;

public class MonetaryAmount {
	private BigDecimal amount;
	private Currency currency;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public int hashCode(){
		return 0;
	}
	
	public boolean equals(Object o){
		if (o == null) return false;
		if (!(o instanceof MonetaryAmount)) return false;
		MonetaryAmount ma = (MonetaryAmount) o;
		return (ma.getAmount().equals(this.getAmount()) && ma.getCurrency().getCurrencyCode().equalsIgnoreCase(this.getCurrency().getCurrencyCode()));
	}
}
