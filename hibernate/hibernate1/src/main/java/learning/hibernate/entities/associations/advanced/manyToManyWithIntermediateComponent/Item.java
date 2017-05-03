package learning.hibernate.entities.associations.advanced.manyToManyWithIntermediateComponent;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<CategoryItem> getCateogoryItems() {
		return cateogoryItems;
	}

	public void setCateogoryItems(Set<CategoryItem> cateogoryItems) {
		this.cateogoryItems = cateogoryItems;
	}
	
	
}
