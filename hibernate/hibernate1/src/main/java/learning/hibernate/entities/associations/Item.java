package learning.hibernate.entities.associations;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {
	@Id
	Long id;
	
	@OneToMany(mappedBy="item"/*mapped by also specified inverse="true" - Bid will cascade updates*/
		, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}
	)
	@org.hibernate.annotations.Cascade(value={org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	Set<Bid> bids;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	
	
}
