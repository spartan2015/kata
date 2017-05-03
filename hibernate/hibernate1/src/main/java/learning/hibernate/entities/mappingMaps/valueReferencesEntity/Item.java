package learning.hibernate.entities.mappingMaps.valueReferencesEntity;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Item {
	@Id
	Long id;
	
	@OneToMany
	@MapKey(name="id") // it maps a property of the target entity as key of the map.
	// Because the keys of a map form a set, values are expected to be unique for a particular map
	Map<Long, Bid> bids;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Long, Bid> getBids() {
		return bids;
	}

	public void setBids(Map<Long, Bid> bids) {
		this.bids = bids;
	}
	
	
}
