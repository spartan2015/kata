package learning.hibernate.entities.collectionsOfComponents;

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

import org.hibernate.annotations.SortType;

@Entity
public class Item {
	@Id
	Long id;

	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name = "arrayOfImages", joinColumns = @JoinColumn(name = "item_id"))
	@org.hibernate.annotations.IndexColumn(base = 0, name = "position")
	Image[] arrayOfImages;

	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name = "collectionOfImages", joinColumns = @JoinColumn(name = "item_id"))
	@org.hibernate.annotations.CollectionId(
			columns = @Column(name = "id"), 
			type = @org.hibernate.annotations.Type(type = "long"), 
			generator = "sequence")
	Collection<Image> collectionOfImages = new ArrayList<Image>();

	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name = "setOfImages", joinColumns = @JoinColumn(name = "item_id"))
	Set<Image> setOfImages = new HashSet<Image>();

	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name = "sortedSetOfImages", joinColumns = @JoinColumn(name = "item_id"))
	@org.hibernate.annotations.Sort(type = SortType.COMPARATOR, comparator = learning.hibernate.entities.collectionsOfComponents.ImageComparator.class)
	SortedSet<Image> sortedSetOfImages = new TreeSet<Image>();

	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name = "listOfImages", joinColumns = @JoinColumn(name = "item_id"))
	@org.hibernate.annotations.IndexColumn(base = 0, name = "position")
	List<Image> listOfImages = new ArrayList<Image>();

	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name = "mapOfImages", joinColumns = @JoinColumn(name = "item_id"))
	@org.hibernate.annotations.MapKey(columns = @Column(name = "key"), targetElement = java.lang.String.class)
	Map<String, Image> mapOfImages = new HashMap<String, Image>();

	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name = "sortedMapOfImages", joinColumns = @JoinColumn(name = "sortedMapOfImages"))
	@org.hibernate.annotations.MapKey(columns = @Column(name = "key"), targetElement = java.lang.String.class)
	@org.hibernate.annotations.Sort(type = SortType.NATURAL)
	SortedMap<String, Image> sortedMapOfImages = new TreeMap<String, Image>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Image[] getArrayOfImages() {
		return arrayOfImages;
	}

	public void setArrayOfImages(Image[] arrayOfImages) {
		this.arrayOfImages = arrayOfImages;
	}

	public Collection<Image> getCollectionOfImages() {
		return collectionOfImages;
	}

	public void setCollectionOfImages(Collection<Image> collectionOfImages) {
		this.collectionOfImages = collectionOfImages;
	}

	public Set<Image> getSetOfImages() {
		return setOfImages;
	}

	public void setSetOfImages(Set<Image> setOfImages) {
		this.setOfImages = setOfImages;
	}

	public SortedSet<Image> getSortedSetOfImages() {
		return sortedSetOfImages;
	}

	public void setSortedSetOfImages(SortedSet<Image> sortedSetOfImages) {
		this.sortedSetOfImages = sortedSetOfImages;
	}

	public List<Image> getListOfImages() {
		return listOfImages;
	}

	public void setListOfImages(List<Image> listOfImages) {
		this.listOfImages = listOfImages;
	}

	public Map<String, Image> getMapOfImages() {
		return mapOfImages;
	}

	public void setMapOfImages(Map<String, Image> mapOfImages) {
		this.mapOfImages = mapOfImages;
	}

	public SortedMap<String, Image> getSortedMapOfImages() {
		return sortedMapOfImages;
	}

	public void setSortedMapOfImages(SortedMap<String, Image> sortedMapOfImages) {
		this.sortedMapOfImages = sortedMapOfImages;
	}

}
