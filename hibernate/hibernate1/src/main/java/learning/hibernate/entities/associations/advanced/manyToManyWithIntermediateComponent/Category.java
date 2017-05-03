package learning.hibernate.entities.associations.advanced.manyToManyWithIntermediateComponent;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	
	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name="category_item", joinColumns=@JoinColumn(name="category_id"))
	Set<CategoryItem> categoryItems = new HashSet<CategoryItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<CategoryItem> getCategoryItems() {
		return categoryItems;
	}

	public void setCategoryItems(Set<CategoryItem> categoryItems) {
		this.categoryItems = categoryItems;
	}
	
	
	
}
