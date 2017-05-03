package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class SortingCollectionsAndArrays {
	
	public static void main(String[] args) {
		
		// WHEN SORTING, the ELEMENTS MUST IMPLEMENT COMPARABLE !!! otherwise: you get Runtime Exception
		List<String> list = new ArrayList<String>();
		list.add("3");
		list.add("2");
		list.add("1");
		System.out.println(list);
		
		Collections.sort(list);
		Collections.sort(list, new Comparator<String>(){
			public int compare(String s1, String s2){
				return s1.compareTo(s2);
			}
		});
		
		System.out.println(list);
		
		String[] strs = {"3", "2", "1"};
		
		System.out.println(Arrays.toString(strs));
		
		//  Don't be fooled by an exam question used to sort a primitive array using a comparator: COMPILE ERROR !!!

		Arrays.sort(strs);
		Arrays.sort(strs, new Comparator<String>(){
			public int compare(String s1, String s2){
				return s1.compareTo(s2);
			}
		});
		
		System.out.println(Arrays.toString(strs));
		
		
		// before you search - SORT !!!! - otherwise bad searched happen
		int index = Collections.binarySearch(list,"1");
		System.out.println("found 1 at: " + index);
		
		int index2 = Collections.binarySearch(list,"2");
		System.out.println("found 2 at: " + index2);
		
		int index3 = Collections.binarySearch(list,"3");
		System.out.println("found 3 at: " + index3);
		
		index3 = Collections.binarySearch(list,"3", new Comparator<String>(){
			public int compare(String s1, String s2){
				return s2.compareTo(s1);
			}
		});
		System.out.println("(bad comparator - it's not sorted after it:)found 3 at: " + index3);
		
	}

}
