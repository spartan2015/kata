package learning.hibernate.entities.associations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bid {
	@Id
	Long id;
	
	@ManyToOne(optional=false /*not null constraint*/) 
	@JoinColumn(name="item_id",nullable=false)
	Item item;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
