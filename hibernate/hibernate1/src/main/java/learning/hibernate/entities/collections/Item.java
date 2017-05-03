package learning.hibernate.entities.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.SortType;

@Entity
public class Item {
	@Id
	Long id;
	
	int[] primitiveArray;
	
	String[] arrayImages;
	
	@org.hibernate.annotations.CollectionOfElements(targetElement=java.lang.String.class)
	@JoinTable(name="bagImages",joinColumns=@JoinColumn(name="item_id"))
	@Column(name="filename")
	Collection<String> bagImages = new ArrayList<String>();
	
	@org.hibernate.annotations.CollectionOfElements(targetElement=java.lang.String.class)
	@JoinTable(name="listImages",joinColumns=@JoinColumn(name="item_id"))
	@Column(name="filename")
	@org.hibernate.annotations.IndexColumn(base=0,name="position")
	List<String> listImages = new ArrayList<String>();
	
	/*
	 * mapping a collection of  VALUES - not entities. - this is not available in JPA
	 */
	@org.hibernate.annotations.CollectionOfElements(targetElement=String.class)
	@JoinTable(name="images",joinColumns=@JoinColumn(name="item_id"))
	@Column(name="filename")
	@org.hibernate.annotations.OrderBy(clause="filename asc")
	Set<String> images = new HashSet<String>(); // initialize write away !
	
	@org.hibernate.annotations.CollectionOfElements(targetElement=String.class)
	@JoinTable(name="sortedImages",joinColumns=@JoinColumn(name="item_id"))
	@Column(name="filename")
	@org.hibernate.annotations.Sort(type=org.hibernate.annotations.SortType.NATURAL)
	SortedSet<String> sortedImages = new TreeSet<String>();
	
	
	@org.hibernate.annotations.CollectionOfElements(targetElement=java.lang.String.class)
	@JoinTable(name="mapImages",joinColumns=@JoinColumn(name="item_id"))
	@Column(name="filename")
	@org.hibernate.annotations.MapKey(targetElement=java.lang.String.class,columns=@Column(name="imageName"))
	Map<String,String> mapImages = new HashMap<String, String>(); 
	
	SortedMap<String, String> sortedMapImages = new TreeMap<String,String>();
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

	public SortedSet<String> getSortedImages() {
		return sortedImages;
	}

	public void setSortedImages(SortedSet<String> sortedImage) {
		this.sortedImages = sortedImage;
	}

	public List<String> getListImages() {
		return listImages;
	}

	public void setListImages(List<String> listImages) {
		this.listImages = listImages;
	}

	public Collection<String> getBagImages() {
		return bagImages;
	}

	public void setBagImages(Collection<String> bagImages) {
		this.bagImages = bagImages;
	}

	public Map<String, String> getMapImages() {
		return mapImages;
	}

	public void setMapImages(Map<String, String> mapImages) {
		this.mapImages = mapImages;
	}

	public SortedMap<String, String> getSortedMapImages() {
		return sortedMapImages;
	}

	public void setSortedMapImages(SortedMap<String, String> sortedMapImages) {
		this.sortedMapImages = sortedMapImages;
	}

	public int[] getPrimitiveArray() {
		return primitiveArray;
	}

	public void setPrimitiveArray(int[] primitiveArray) {
		this.primitiveArray = primitiveArray;
	}

	public String[] getArrayImages() {
		return arrayImages;
	}

	public void setArrayImages(String[] arrayImages) {
		this.arrayImages = arrayImages;
	}

	
}

