package org.mseco.learning.hibernate2.associations.optionalOneToManyWithAJoinTable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name="addresses")
public class Address {
	@Id
	private Long id;
	
	@ManyToOne
	@JoinTable(name="addresses",joinColumns=@JoinColumn(name="address_id"),inverseJoinColumns=@JoinColumn(name="person_id"))
	private Person person;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}	
}
