package learning.hibernate.entities.inheritance.tablePerClassHierarchy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class BankAccount extends BillingDetails{
	String account;
}
