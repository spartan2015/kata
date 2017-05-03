package learning.hibernate.entities.inheritance.tablePerClassHierarchy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("C")
public class CreditCard extends BillingDetails {
	
	String cardNumber;
}
