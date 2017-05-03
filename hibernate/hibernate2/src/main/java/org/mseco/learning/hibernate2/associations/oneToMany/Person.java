package org.mseco.learning.hibernate2.associations.oneToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.IndexColumn;


@Entity
public class Person {
	@Id
	private Long id;
	
	@OneToMany(mappedBy="person",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	@org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@JoinColumn(name="person_id")
	Set<Address> addresses = new HashSet<Address>();

	@OneToMany // because mappedBy is not present - semanticly correct for LIST types - this side is responsible for synch with the db
	@IndexColumn(name="list_index")
	@JoinColumn(name="Person_id")
	List<Address> addresses_list = new ArrayList<Address>();
	
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
