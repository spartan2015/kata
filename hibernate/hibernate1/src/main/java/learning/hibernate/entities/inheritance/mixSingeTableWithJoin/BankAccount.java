package learning.hibernate.entities.inheritance.mixSingeTableWithJoin;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="bankAccountId")
public class BankAccount extends BillingDetails{
	String account;
}
