package learning.hibernate.entities.inheritance.concreteClassImplicit;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // if this is not here then the superclass properties are NOT persisted
public abstract class BillingDetails {
	@Column(name="owner")
	String owner;
}
