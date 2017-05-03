package learning.hibernate.entities.associations.advanced.manyToManyWithIntermediateEntity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CategoryItem {
	@Id
	@EmbeddedId
	CategoryItemId id;
	
	@Embeddable
	static class CategoryItemId{
		Long categoryId;
		Long itemId;
		
		public CategoryItemId(){}
		
		public CategoryItemId(Long categoryId, Long itemId){
			this.categoryId = categoryId;
			this.itemId = itemId;
		}
		
		public boolean equals(Object object){
			if (object == null){
				return false;
			}
			
			if (!(object instanceof CategoryItemId)){
				return false;
			}
			
			CategoryItemId o2 = (CategoryItemId)object;
			
			if (o2.categoryId.equals(this.categoryId) && o2.itemId.equals(this.itemId)){
				return true;
			}else{
				return false;
			}
		}
		public int hashCode(){
			return (int)(categoryId + itemId);
		}
	}
	
	@ManyToOne
	@JoinColumn(name="category_id")
	Category category;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	Item item;


	public Category getCategory() {
		return category;
	}



	public void setId(CategoryItemId id) {
		this.id = id;
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
