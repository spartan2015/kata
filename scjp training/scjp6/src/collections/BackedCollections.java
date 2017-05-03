package collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class BackedCollections {
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(4);
		treeSet.add(5);
		
		SortedSet<Integer> subset = treeSet.subSet(2/*inclusiveByDefault*/, 4 /*exclusiveByDefault*/);
		System.out.println(subset);
		// you can't add in the subset anything that is not withing it's set boundaries		
		//subset.add(4); // java.lang.IllegalArgumentException: key out of range
		
		SortedSet<Integer> headSet = treeSet.headSet(3 /*toElement is exclusive by default*/);
		System.out.println(headSet);
		
		
		SortedSet<Integer> tailSet = treeSet.tailSet(3 /*fromElement is inclusive by default*/);
		System.out.println(tailSet);
		// the two set's are joined at the hip
		
	}
}
