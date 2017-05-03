package org.mseco.learning.hibernate2.associations.manyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Category {
	@Id
	private Long id;
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="categories")
	@JoinTable(name="items",joinColumns=@JoinColumn(name="category_id"),inverseJoinColumns=@JoinColumn(name="item_id"))
	private Set<Item> items = new HashSet<Item>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
	
}
