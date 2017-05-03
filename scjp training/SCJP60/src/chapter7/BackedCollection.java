package chapter7;

import java.util.SortedMap;
import java.util.TreeMap;

public class BackedCollection {

	
	public static void main(String[] args) {
	
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();		
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		
		SortedMap<Integer,Integer> backedCollection = map.subMap(2, 6);
		System.out.println("backedCollection: " + backedCollection);		
		map.put(5,5);// you modify the collection, the backedCollection is refreshed		
		System.out.println("backedCollection: " + backedCollection); 
		backedCollection.put(7, 7); // out of range - RuntimeException - java.lang.IllegalArgumentException: key out of range
		// the backedCollection can have only the defined range 
	}

}
