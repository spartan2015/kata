package learning.hibernate.entities.associations.advanced.manyToManyWithIntermediateEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@OneToMany(mappedBy="item")
	@JoinColumn(name="item_id")
	Set<CategoryItem> cateogoryItems = new HashSet<CategoryItem>();
}
