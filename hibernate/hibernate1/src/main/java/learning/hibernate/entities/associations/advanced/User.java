package learning.hibernate.entities.associations.advanced;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class User {
	@Id
	Long id;
	
	/**
	 * This is all that is needed to create a unidirectional one-to-one association on a
shared primary key.
	 */	
	/**
	 * The JPA specification doesn’t include a standardized method to deal with the
problem of shared primary key generation, which means you’re responsible for
setting the identifier value of an Address instance correctly before you save it (to
the identifier value of the linked User instance). Hibernate has an extension
annotation for custom identifier generators which you can use with the Address
entity (just like in XML):

	 */
	@OneToOne
	@PrimaryKeyJoinColumn
	Address address;
	
	@ManyToOne
	@JoinColumn
	Address shippingAddress;
	
	String name;

	
	
	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
