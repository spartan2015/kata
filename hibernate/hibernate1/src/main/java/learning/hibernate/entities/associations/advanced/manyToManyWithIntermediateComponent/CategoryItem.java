package learning.hibernate.entities.associations.advanced.manyToManyWithIntermediateComponent;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Parent;

@Embeddable
public class CategoryItem {

	
	@Parent
	Category category;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	Item item;
	
	public boolean equals(Object object){
		if (object instanceof CategoryItem){
			CategoryItem o2 = (CategoryItem)object;
			if (o2.getCategory().getId().equals(category.getId()) && o2.getItem().getId().equals(item.getId())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public int hashCode(){
		return 1;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	
	
	
}
