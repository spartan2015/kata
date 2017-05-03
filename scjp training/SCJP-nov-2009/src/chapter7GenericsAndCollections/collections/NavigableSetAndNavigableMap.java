package chapter7GenericsAndCollections.collections;

import java.util.TreeMap;
import java.util.TreeSet;

public class NavigableSetAndNavigableMap {

	public static void main(String[] args) {

		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		System.out.println(set.higher(2) + " = 3");
		System.out.println(set.ceiling(2) + " = 2");
		System.out.println(set.floor(2) + " = 2");
		System.out.println(set.lower(2) + " = 1");
		
		System.out.println(set.headSet(3) + "[1,2]");
		System.out.println(set.subSet(1, 3) + "[1,2]");
		System.out.println(set.tailSet(3) + "[3,4]");
		
		System.out.println("========== Map ===========");
		
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		
		System.out.println(map.higherKey(2) + " = 3");
		System.out.println(map.ceilingKey(2) + " = 2");
		System.out.println(map.floorKey(2) + " = 2");
		System.out.println(map.lowerKey(2) + " = 1");
		
		System.out.println(map.headMap(3) + "[1,2]");
		System.out.println(map.subMap(1,3) + "[1,2]");
		System.out.println(map.tailMap(3) + "[3,4]");
		
		/**
		 * CONCLUSION
		 * I. FROM INCLUSIVE
		 * II. TO ECLUSIVE
		 * 
		 */
	}

}
