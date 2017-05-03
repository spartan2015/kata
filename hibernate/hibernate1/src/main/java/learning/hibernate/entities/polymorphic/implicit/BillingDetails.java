package learning.hibernate.entities.polymorphic.implicit;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetails {
	String owner;
}	
