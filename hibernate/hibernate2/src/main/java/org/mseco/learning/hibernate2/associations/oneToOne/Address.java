package org.mseco.learning.hibernate2.associations.oneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Parameter;

@Entity
public class Address {
	
	/*
	 * The JPA specification doesn’t include a standardized method to deal with the
problem of shared primary key generation, which means you’re responsible for
setting the identifier value of an Address instance correctly before you save it (to
the identifier value of the linked User instance). Hibernate has an extension
annotation for custom identifier generators which you can use with the Address
entity (just like in XML):
	 */
	@Id
	@org.hibernate.annotations.GenericGenerator(name="foreign",strategy="foreign",
			parameters={@Parameter(name="property",value="user")})
	@GeneratedValue(generator="foregin")
	private Long id;
	
	
	@OneToOne(mappedBy="address")	
	private User user;
	
	@OneToOne(mappedBy="secondAddress")
	private User secondUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getSecondUser() {
		return secondUser;
	}

	public void setSecondUser(User secondUser) {
		this.secondUser = secondUser;
	}
	
	
}
