package learning.hibernate.entities.inheritance.concreteClassImplicit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount extends BillingDetails{
	@Id
	Long id;
}
