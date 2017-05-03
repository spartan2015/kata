package learning.hibernate.entities.inheritance.mixSingeTableWithJoin;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED /*equivalent with hibernate mapping xml : joined-subclass*/)
/*
 * In subclasses, you don’t need to specify the join column if the primary key column
of the subclass table has (or is supposed to have) the same name as the primary
key column of the superclass table:
 */
public abstract class BillingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column(name="owner")
	String owner;
}
