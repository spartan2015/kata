package learning.hibernate.entities.customtypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

public class MonetaryAmount implements Serializable {

	private final BigDecimal amount;
	private final Currency currency;
	
	
	public MonetaryAmount(BigDecimal amount, Currency currency){
		this.amount = amount;
		this.currency = currency;		
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public Currency getCurrency() {
		return currency;
	}
	
	public MonetaryAmount convertTo(Currency currency){
		System.out.println("converting");
		return this;
	}
	
}
