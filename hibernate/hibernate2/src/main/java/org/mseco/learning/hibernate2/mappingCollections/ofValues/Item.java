package org.mseco.learning.hibernate2.mappingCollections.ofValues;

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
import javax.persistence.OrderBy;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.SortType;
import org.hibernate.annotations.Type;

@Entity
public class Item {
	@Id
	private Long id;
	
	
	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name="numbers",joinColumns=@JoinColumn(name="Item_id"))
	@Column(name="number")
	int[] numbers;
	
	@org.hibernate.annotations.CollectionOfElements(
			targetElement=String.class)
	@JoinTable(name="images_names_unique",joinColumns=@JoinColumn(name="Item_id"))
	@Column(name="image_name")
	Collection images_names_unique = new ArrayList();
	
	@org.hibernate.annotations.CollectionOfElements(
			targetElement=String.class)
	@JoinTable(name="images_names_duplicates",joinColumns=@JoinColumn(name="Item_id"))
	@Column(name="image_name")
	@CollectionId(type=@Type(type="long"),columns=@Column(name="collectionId"), generator = "increment")
	Collection images_names_duplicates = new ArrayList();
	
	Image[] images_array;
		
	@org.hibernate.annotations.CollectionOfElements(
			targetElement=Image.class)
	@JoinTable(name="images_bag",joinColumns=@JoinColumn(name="Item_id"))
	@Columns(columns={@Column(name="image_name")})
	Collection<Image> images_bag = new ArrayList<Image>();
	
	@org.hibernate.annotations.CollectionOfElements()
	@JoinTable(name="images_set",joinColumns=@JoinColumn(name="Item_id"))
	@Column(name="image_name")
	@OrderBy(value="image_name")
	Set<Image> images_set = new HashSet<Image>();
	
	@org.hibernate.annotations.CollectionOfElements()
	@JoinTable(name="images_set_sorted",joinColumns=@JoinColumn(name="Item_id"))
	@Column(name="image_name")
	@org.hibernate.annotations.Sort(type=SortType.NATURAL)
	SortedSet<Image> images_set_sorted = new TreeSet<Image>();
	
	@org.hibernate.annotations.CollectionOfElements()
	@JoinTable(name="images_list",joinColumns=@JoinColumn(name="Item_id"))
	@Column(name="image_name")
	@IndexColumn(base=0,name="list_index")
	List<Image> images_list = new ArrayList<Image>();
	
	@org.hibernate.annotations.CollectionOfElements()
	@OrderBy(value="image_name")
	@Columns(columns={@Column(name="image_name")})
	@javax.persistence.MapKey(name="map_key")
	Map<String,Image> images_map = new  HashMap<String,Image>();
	
	@org.hibernate.annotations.CollectionOfElements()
	@OrderBy(value="image_name")
	@Columns(columns={@Column(name="image_name")})
	@javax.persistence.MapKey(name="map_key")
	@org.hibernate.annotations.Sort(type=SortType.NATURAL)
	SortedMap<String,Image> images_map_sorted = new TreeMap<String,Image>();

	@org.hibernate.annotations.CollectionOfElements()
	@OrderBy(value="image_name")
	@Columns(columns={@Column(name="image_name")})
	@org.hibernate.annotations.MapKey(targetElement=Image.class,columns={@Column(name="image_name_key")})
	Map<Image,Image> images_map_compositekey = new HashMap<Image,Image>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Image[] getImages_array() {
		return images_array;
	}

	public void setImages_array(Image[] imagesArray) {
		images_array = imagesArray;
	}

	public Collection<Image> getImages_bag() {
		return images_bag;
	}

	public void setImages_bag(Collection<Image> imagesBag) {
		images_bag = imagesBag;
	}

	public Set<Image> getImages_set() {
		return images_set;
	}

	public void setImages_set(Set<Image> imagesSet) {
		images_set = imagesSet;
	}

	

	public SortedSet<Image> getImages_set_sorted() {
		return images_set_sorted;
	}

	public void setImages_set_sorted(SortedSet<Image> imagesSetSorted) {
		images_set_sorted = imagesSetSorted;
	}

	public List<Image> getImages_list() {
		return images_list;
	}

	public void setImages_list(List<Image> imagesList) {
		images_list = imagesList;
	}

	public Map<String, Image> getImages_map() {
		return images_map;
	}

	public void setImages_map(Map<String, Image> imagesMap) {
		images_map = imagesMap;
	}

	public SortedMap<String, Image> getImages_map_sorted() {
		return images_map_sorted;
	}

	public void setImages_map_sorted(SortedMap<String, Image> imagesMapSorted) {
		images_map_sorted = imagesMapSorted;
	}

	public Map<Image, Image> getImages_map_compositekey() {
		return images_map_compositekey;
	}

	public void setImages_map_compositekey(Map<Image, Image> imagesMapCompositekey) {
		images_map_compositekey = imagesMapCompositekey;
	}




	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public Collection getImages_names_unique() {
		return images_names_unique;
	}

	public void setImages_names_unique(Collection imagesNamesUnique) {
		images_names_unique = imagesNamesUnique;
	}

	public Collection getImages_names_duplicates() {
		return images_names_duplicates;
	}

	public void setImages_names_duplicates(Collection imagesNamesDuplicates) {
		images_names_duplicates = imagesNamesDuplicates;
	}


	
	
}
