package org.mseco.learning.hibernate2.mappingCollections.ofValues;

import javax.persistence.Embeddable;

/*
You must implement equals() (and hashCode())
- p 252

 */
@Embeddable
public class Image implements Comparable<Image>{
	
	@org.hibernate.annotations.Parent
	private Item parent;
	private String name;
	
	public int compareTo(Image image) {
		
		return name.compareTo(image.getName());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getParent() {
		return parent;
	}

	public void setParent(Item parent) {
		this.parent = parent;
	}
	
	
	
}
