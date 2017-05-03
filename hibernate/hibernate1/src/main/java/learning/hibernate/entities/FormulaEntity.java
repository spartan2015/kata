package learning.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.Formula;

@Entity
public class FormulaEntity {
	
	@Id
	Long id;
	
	@Version // turns on optimistic  locking
	long version;
	
	@Formula("1+1")
	String name;
}
