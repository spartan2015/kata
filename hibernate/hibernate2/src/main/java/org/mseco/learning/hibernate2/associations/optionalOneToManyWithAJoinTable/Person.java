package org.mseco.learning.hibernate2.associations.optionalOneToManyWithAJoinTable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	private Long id;
	
	@OneToMany(mappedBy="person") // weird mapping but real - in xml is a many-to-many - here is a oneToMany -- se page 297
	private Set<Address> addresses = new HashSet<Address>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}
