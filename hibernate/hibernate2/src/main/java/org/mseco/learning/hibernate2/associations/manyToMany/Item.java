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
public class Item {
	@Id
	private Long id;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="items",joinColumns=@JoinColumn(name="item_id"),inverseJoinColumns=@JoinColumn(name="category_id"))
	private Set<Category> categories = new HashSet<Category>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
}
