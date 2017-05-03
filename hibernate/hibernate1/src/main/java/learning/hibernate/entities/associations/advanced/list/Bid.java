package learning.hibernate.entities.associations.advanced.list;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bid {
	@Id
	Long id;
	
	@ManyToOne
	@JoinColumn(name="item_id",insertable=false, updatable=false, nullable=false)
	Item item;
}
