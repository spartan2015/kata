package org.mseco.learning.hibernate2.mappingTypes.enumTypes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	private Long id;	
	@Enumerated(EnumType.STRING)
	private Rating rating;
	
	@Enumerated(EnumType.STRING)
	private Rating secondRating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Rating getSecondRating() {
		return secondRating;
	}
	public void setSecondRating(Rating secondRating) {
		this.secondRating = secondRating;
	}	
}
