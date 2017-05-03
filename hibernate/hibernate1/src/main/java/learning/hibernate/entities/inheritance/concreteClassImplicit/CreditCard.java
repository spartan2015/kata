package learning.hibernate.entities.inheritance.concreteClassImplicit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCard extends BillingDetails {
	@Id
	Long id;
}
