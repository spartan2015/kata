package learning.hibernate.entities.inheritance.tablePerSUBClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@DiscriminatorValue("creditCard")
@SecondaryTable(name="creditCard", pkJoinColumns=@PrimaryKeyJoinColumn(name="creditCardId"))
public class CreditCard extends BillingDetails {
	
	String cardNumber;
}
