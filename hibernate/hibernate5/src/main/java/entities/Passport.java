package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

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
