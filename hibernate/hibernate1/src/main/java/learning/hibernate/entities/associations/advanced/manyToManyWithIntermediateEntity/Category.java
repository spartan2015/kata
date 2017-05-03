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
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@OneToMany(mappedBy="category")
	@JoinColumn(name="category_id")
	Set<CategoryItem> categoryItems = new HashSet<CategoryItem>();
}
