package learning.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="seqe")
@SequenceGenerator(sequenceName="mySequence",name="seq",initialValue=1)
public class SequenceExample {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")	
	Long id;
}
