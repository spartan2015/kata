package org.mseco.learning.hibernate2.mappingMaps.ternary;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany
	@org.hibernate.annotations.MapKeyManyToMany(joinColumns=@JoinColumn(name="Item_id"))
	@JoinTable(joinColumns=@JoinColumn(name="Category_id"),inverseJoinColumns=@JoinColumn(name="User_id"))	
	private Map<Item,User> items = new HashMap<Item,User>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Item, User> getItems() {
		return items;
	}

	public void setItems(Map<Item, User> items) {
		this.items = items;
	}	
}
