package entities;

import javax.persistence.Entity;

@Entity
public class NationalId extends IdentityCard {
	
	private String cnp;

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	
}
