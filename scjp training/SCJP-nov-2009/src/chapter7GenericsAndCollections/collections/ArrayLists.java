package chapter7GenericsAndCollections.collections;

import java.util.ArrayList;

public class ArrayLists {

	
	public static void main(String[] args) {
		
		/**
		 * FAST RANDOM ACCESS
		 * FAST ITTERATION
		 * ORDERED COLLECTION
		 * 
		 * implements RandomAccess interface !!!
		 */
		ArrayList<String> list = new ArrayList<String>();

		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		// size()
		System.out.println(list.size());
		
		// contains()
		System.out.println(list.contains("a"));
		
		// remove
		list.remove(3);
		list.remove("a");
		
		System.out.println(list);
		
				
	}

}
