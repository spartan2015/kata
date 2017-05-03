package learning.hibernate.entities;

import javax.persistence.Id;

@org.hibernate.annotations.Entity(mutable=false)
public class ImmutableEntity {
	@Id
	Long id;
}
