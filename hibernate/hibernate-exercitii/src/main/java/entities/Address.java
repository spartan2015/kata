package entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
