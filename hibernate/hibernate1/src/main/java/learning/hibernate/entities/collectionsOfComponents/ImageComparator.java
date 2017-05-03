package learning.hibernate.entities.collectionsOfComponents;

import java.util.Comparator;

public class ImageComparator implements Comparator<Image>{
	public int compare(Image a, Image b){
		return a.getName().compareTo(b.getName());
	}
}
