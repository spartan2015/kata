package chapter7.collections;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class TreeSetNavigableSetInterface {

	public static void main(String args[]){
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		set.addAll(Arrays.asList(new Integer[]{1,2,3,4}));
		
		// NavigableSet
		System.out.println(set.lower(2) + " = 1");
		System.out.println(set.ceiling(2) + " = 2");
		System.out.println(set.floor(3) + " = 3"); // return E <= Param
		System.out.println(set.higher(3) + " = 4");
		
		System.out.println(set);
		
		System.out.println(set.headSet(3) + " = [1,2]" );
		System.out.println(set.headSet(3,true) + " = [1,2,3]");
		
		System.out.println(set.tailSet(3) + " = [3,4]");
		System.out.println(set.tailSet(3,false) + " = [4]");
		
		System.out.println(set.subSet(3, 4) + " = [3]");
		System.out.println(set.subSet(3,false, 4,true) + " = [4]");
		
		System.out.println(set.descendingSet());
		
	}		
	
}
