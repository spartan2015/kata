package entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedEntity {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}