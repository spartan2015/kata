package entities;

import javax.persistence.Entity;

@Entity	
public class Bus extends Car{
	private Long seats;

	public Long getSeats() {
		return seats;
	}

	public void setSeats(Long seats) {
		this.seats = seats;
	}	
}
