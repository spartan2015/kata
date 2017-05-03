package learning.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="myTableGenerator",table="tableForIdGeneration")
public class TableGeneratorExample {
	@Id
	@GeneratedValue(generator="myTableGenerator",strategy=GenerationType.TABLE)
	Long id;
}
