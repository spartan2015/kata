package org.mseco.learning.hibernate2.mappingMaps;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	//IT SEARCHES FOR A PROPERTY OF THE KEY!!! @MapKey(name="bid_id") // Map key property not found: org.mseco.learning.hibernate2.mappingMaps.Bid.bid_id
	@MapKey(name="id")
	@OneToMany
	@JoinColumn(name="Item_id")
	//@JoinTable(joinColumns=@JoinColumn(name="item_id"),inverseJoinColumns=@JoinColumn(name="bid_id"))	
	private Map<Long,Bid> bids = new HashMap<Long,Bid>();

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
