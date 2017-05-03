package chapter7GenericsAndCollections.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SortingCollections {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		list.add("c");
		list.add("d");
		list.add("b");
		list.add("a");
		
		System.out.println(list);
		
		Collections.sort(list); // String IS-A Comparable
		
		System.out.println(list);
		
	}
}
