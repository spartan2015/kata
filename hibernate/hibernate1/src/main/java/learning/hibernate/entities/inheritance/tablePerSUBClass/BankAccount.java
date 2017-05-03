package learning.hibernate.entities.inheritance.tablePerSUBClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BA")
public class BankAccount extends BillingDetails{
	String account;
}
