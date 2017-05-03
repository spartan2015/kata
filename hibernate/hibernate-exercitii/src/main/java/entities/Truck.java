package entities;

import javax.persistence.Entity;

@Entity
public class Truck extends Car{
	private Long loadCapacity;

	public Long getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(Long loadCapacity) {
		this.loadCapacity = loadCapacity;
	}
	
	
}
