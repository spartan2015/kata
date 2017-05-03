package learning.hibernate.entities.polymorphic.manyToOne;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class  BillingDetails {
	@Id
	Long id;
}
