package learning.hibernate.entities.inheritance.tablePerClassHierarchy;

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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE /*equivalent with hibernate mapping xml : union-subclass*/)
/**
 * SINGLE_TABLE
 *   There is one major problem: Columns for properties declared by subclasses
must be declared to be nullable.
 */
@DiscriminatorColumn(name="DISCRIMINATOR",discriminatorType=DiscriminatorType.STRING)
public abstract class BillingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column(name="owner")
	String owner;
}
