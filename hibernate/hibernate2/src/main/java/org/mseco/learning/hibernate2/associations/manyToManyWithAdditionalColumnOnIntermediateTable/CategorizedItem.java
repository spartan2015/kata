package org.mseco.learning.hibernate2.associations.manyToManyWithAdditionalColumnOnIntermediateTable;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CategorizedItem implements Serializable{
	
	public CategorizedItem(Category category, Item item, String desc){
		this.category = category;
		category.getCategorizedItems().add(this);
		this.item = item;
		item.getCategorizedItems().add(this);				
		this.categorizedItemId = new CategorizedItemId(category.getId(), item.getId());
		this.desc = desc;			
	}
	
	@Embeddable
	public static class CategorizedItemId implements Serializable{
		private Long categoryId;
		private Long itemId;
		
		CategorizedItemId(Long categoryId, Long itemId){
			this.categoryId = categoryId;
			this.itemId = itemId;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof CategorizedItemId)) return false;
			return super.equals(obj);
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return categoryId.hashCode() + itemId.hashCode();
		}
	}
	
	@EmbeddedId
	private CategorizedItemId categorizedItemId;
	@ManyToOne(cascade=CascadeType.ALL)
	private Category category;
	@ManyToOne(cascade=CascadeType.ALL)
	private Item item;
	
	private String desc;
	
	public CategorizedItemId getCategorizedItemId() {
		return categorizedItemId;
	}
	public void setCategorizedItemId(CategorizedItemId categorizedItemId) {
		this.categorizedItemId = categorizedItemId;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
