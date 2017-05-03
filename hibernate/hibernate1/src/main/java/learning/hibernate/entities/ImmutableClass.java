package learning.hibernate.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@org.hibernate.annotations.Entity(mutable=false)
@org.hibernate.annotations.AccessType("field")
public class ImmutableClass {
	
	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

}
