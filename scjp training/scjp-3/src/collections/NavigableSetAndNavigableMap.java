package collections;

import java.util.TreeMap;
import java.util.TreeSet;

public class NavigableSetAndNavigableMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		System.out.println(set);
		
		System.out.println("set.higher(3): " + set.higher(3));
		System.out.println("set.floor(3): " + set.floor(3));
		
		System.out.println("set.lower(3): " + set.lower(3));
		System.out.println("set.ceiling(3): " + set.ceiling(3));
		
		// similar for the map - but add Key
		
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		System.out.println(map);
		
		System.out.println("map.higherKey(3): " + map.higherKey(3));
		System.out.println("map.floorKey(3)" + map.floorKey(3));
		
		System.out.println("map.lowerKey(3)" + map.lowerKey(3));
		System.out.println("map.ceilingKey(3)" + map.ceilingKey(3));
		
		// descendint
		System.out.println(set.descendingSet());
		System.out.println(map.descendingMap());
		
		// polling: capul - primul - pollFirst
		System.out.println("set.pollFirst()" + set.pollFirst());
		System.out.println("set.pollLast()" + set.pollLast());
		
		System.out.println("set: " + set);
		System.out.println("map: " + map);
	}

}
