package learning.hibernate.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BasicAnnotations {
	@Id
	Long id;
	
	@Basic(optional=false) // not null at java level
	@Column(nullable=false) // generated a not null constraint in the database
	String name;
}
