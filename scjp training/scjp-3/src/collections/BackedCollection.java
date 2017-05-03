package collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class BackedCollection {
	public static void main(String args[]) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(7);
		System.out.println("set" + set);
		SortedSet<Integer> subSet = set.subSet(1,3);
		System.out.println("subSet(1,3): " + subSet);
		set.add(2);
		System.out.println("set.add(2)");
		System.out.println("subSet: " + subSet + " - here is the power of the backed collections");
		
		//subSet.add(4); // will throw an error because the range was 1-3
		
		// headSet(toElement - exclusive);
		System.out.println(set.headSet(2));
		//subSet(fromElement-inclusive, toElement-exclusive)
		System.out.println(set.subSet(1, 2));
		//tailSet(fromElement-inclusive)
		System.out.println(set.tailSet(7));
		
		// same goes for map - only it: headMap, subMap, tailMap
	}
}
