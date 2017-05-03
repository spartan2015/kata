package org.mseco.learning.hibernate2.naming;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
@SequenceGenerator(name="the_sequence",initialValue=1)
public class User {
	@Id
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,generator="the_sequence")
	private Long id;	
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
