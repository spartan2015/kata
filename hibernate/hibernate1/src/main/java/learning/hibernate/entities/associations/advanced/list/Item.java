package learning.hibernate.entities.associations.advanced.list;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Item {
	@Id
	Long id;
	
	@OneToMany
	@JoinColumn(name="item_id")
	@org.hibernate.annotations.IndexColumn(name="position")
	List<Bid> bids = new ArrayList<Bid>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}	
}
