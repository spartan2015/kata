package learning.hibernate.entities.associations.advanced;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Parameter;

@Entity
public class Address {
	/**
	 * The JPA specification doesn’t include a standardized method to deal with the
problem of shared primary key generation, which means you’re responsible for
setting the identifier value of an Address instance correctly before you save it (to
the identifier value of the linked User instance). Hibernate has an extension
annotation for custom identifier generators which you can use with the Address
entity (just like in XML):

	 */
	@Id @GeneratedValue(generator = "myForeignGenerator")
	@org.hibernate.annotations.GenericGenerator(
	    name = "myForeignGenerator",
	    strategy = "foreign",
	    parameters = @Parameter(name = "property", value = "user")
	)
	Long id;
	
	String street;

	@OneToOne(mappedBy="shippingAddress")
	User user;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	
}
