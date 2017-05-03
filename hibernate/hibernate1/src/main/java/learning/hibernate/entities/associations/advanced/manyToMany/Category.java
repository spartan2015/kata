package learning.hibernate.entities.associations.advanced.manyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Category {
	@Id
	Long id;
	
	@ManyToMany
	@JoinTable(name="category_item",joinColumns=@JoinColumn(name="category_id"),inverseJoinColumns=@JoinColumn(name="item_id"))
	Set<Item> items = new HashSet<Item>();
}
