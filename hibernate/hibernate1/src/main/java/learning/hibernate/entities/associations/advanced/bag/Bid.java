package learning.hibernate.entities.associations.advanced.bag;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bid {
	@Id
	Long id;
	
	@ManyToOne
	Item item;
}
