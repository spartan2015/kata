package learning.hibernate.entities.inheritance.concreteClassUnion;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount extends BillingDetails{
	String account;
}
