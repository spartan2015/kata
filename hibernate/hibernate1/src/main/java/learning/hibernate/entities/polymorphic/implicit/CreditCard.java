package learning.hibernate.entities.polymorphic.implicit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCard extends BillingDetails{

	@Id
	Long id;
	String number;
}
