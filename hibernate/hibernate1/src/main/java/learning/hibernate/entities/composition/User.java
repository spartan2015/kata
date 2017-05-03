package learning.hibernate.entities.composition;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	Long id;
	
	String name;
	
	@Embedded
	@AttributeOverride(name="country",column=@Column(name="country",nullable=false))
	Address home;
	
}
