package org.mseco.learning.hibernate2.associations.manyToManyByComponent;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Parent;

@Embeddable
public class CategorizedItem {
	
	@Parent
	private Category category;
	@ManyToOne
	@JoinColumn(name="Item_id")
	private Item item;
	
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
