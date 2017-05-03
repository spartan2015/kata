package learning.hibernate.entities.mappingMaps.ternaryAssociation;

import java.util.HashMap;
import java.util.Map;

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
	@org.hibernate.annotations.MapKeyManyToMany(joinColumns=@JoinColumn(name="item_id"))
	@JoinTable(name="category_item", joinColumns=@JoinColumn(name="category_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
	Map<Item,User> users = new HashMap<Item,User>();
}
