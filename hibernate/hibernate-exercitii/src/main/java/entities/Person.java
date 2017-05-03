package entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSOANA")
public class Person {
	@Id
	private String cnp;

	@Column(name = "nume")
	private String name;

	@Embedded
	private Address address;

	@Column(name = "data_nastere")
	private Date birthDate;

	@OneToMany
	private Set<BillingDetails> billingDetails;

	@OneToMany
	private Set<Pet> pets;

	@OneToMany
	private Set<IdentityCard> ids;

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	private int weight;

	private int height;

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getWeight() {
		return weight;
	}

	public Set<BillingDetails> getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(Set<BillingDetails> billingDetails) {
		this.billingDetails = billingDetails;
	}

	public Set<IdentityCard> getIds() {
		return ids;
	}

	public void setIds(Set<IdentityCard> ids) {
		this.ids = ids;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
