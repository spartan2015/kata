package learning.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity // by default, with annotation, all properties al persistent uneless they are marked withe @Transient
public class TransientPropertyExample {
	@Id
	Long id;

	@Transient
	String name;
}
