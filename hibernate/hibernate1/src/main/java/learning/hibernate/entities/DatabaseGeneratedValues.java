package learning.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.GenerationTime;

@Entity
public class DatabaseGeneratedValues {
	@Id
	Long id;

	@org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
	String name;

}
