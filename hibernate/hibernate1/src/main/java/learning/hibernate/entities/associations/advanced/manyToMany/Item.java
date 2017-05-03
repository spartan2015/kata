package learning.hibernate.entities.associations.advanced.manyToMany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	@Id
	Long id;
	
	@ManyToMany(mappedBy="items")
	@JoinTable(name="category_item",joinColumns=@JoinColumn(name="item_id"),inverseJoinColumns=@JoinColumn(name="category_id"))
	Set<Category> categories;
}
