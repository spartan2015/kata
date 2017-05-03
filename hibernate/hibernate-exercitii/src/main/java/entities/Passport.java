package entities;

import javax.persistence.Entity;

@Entity
public class Passport extends IdentityCard{
	
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}