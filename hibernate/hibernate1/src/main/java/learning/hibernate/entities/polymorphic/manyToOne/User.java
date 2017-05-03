package learning.hibernate.entities.polymorphic.manyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
	@Id
	Long id;
	
	@ManyToOne
	BillingDetails billingDetails;
}
