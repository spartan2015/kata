package learning.hibernate.entities.inheritance.mixSingeTableWithJoin;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="creditCardId")
public class CreditCard extends BillingDetails {
	
	String cardNumber;
}
