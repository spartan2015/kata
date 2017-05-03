package learning.hibernate.entities.collectionsOfComponents;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 *   You must implement
equals() (and hashCode())

 */
@Embeddable
public class Image {
	
	@Column
	String name;
	@Column
	String filename;
	
	@org.hibernate.annotations.Parent
	Item item;
	
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public boolean equals(Object object){		
		if (object == null) return false;
		if (object == this) return true;
		if (object instanceof Image){
			Image image = (Image)object;
			if (image.getName().equals(name) && image.getFilename().equals(filename)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public int hashcode(){
		return name.length();
	}
}
