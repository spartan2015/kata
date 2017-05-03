package learning.hibernate.entities.composition;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	String country;
	String city;
	String street;
	
	@org.hibernate.annotations.Parent
	User user;
}
