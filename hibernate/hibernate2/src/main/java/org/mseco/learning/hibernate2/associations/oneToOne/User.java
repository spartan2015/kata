package org.mseco.learning.hibernate2.associations.oneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class User {
	@Id
	private Long id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Address address;
	
	@OneToOne
	@JoinColumn(unique=true) // one-to-one efectivly by foreign-key 
	private Address secondAddress;

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

	public Address getSecondAddress() {
		return secondAddress;
	}

	public void setSecondAddress(Address secondAddress) {
		this.secondAddress = secondAddress;
	}
	
	
	
}
