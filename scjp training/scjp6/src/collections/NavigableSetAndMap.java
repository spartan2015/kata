package collections;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class NavigableSetAndMap {
	
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(4);
		treeSet.add(5);
		
		o(treeSet.toString());
		
		o("set.floor(3 " + treeSet.floor(3)); // <= 
		o("set.lower(3) " + treeSet.lower(3)); // <
		
		o("set.higher(3) " + treeSet.higher(3)); // > - return the element > than given element
		o("set.ceiling(3) " + treeSet.ceiling(3)); // >= - returns the element >= to the given element
		
		o("set.headSet(3).last() - by default headset is inclusive=false: " +treeSet.headSet(3).last()); // 2 
		o("set.headSet(3,true).last(): " +treeSet.headSet(3,true).last()); // 2
		
		o("set.tailSet(3).first() - by default tailSet is inclusive=true: " + treeSet.tailSet(3).first()); // 3
		o("set.tailSet(3,false).first(): " + treeSet.tailSet(3,false).first()); // 4
		
		// similar methods in Map - floorKey, lowerKey, higherKey, ceilingKey
		
		// Polling: pollFirst(), pollLast - retrieves and removes the element - mai FIFO or LIFO queues imediatly
		// similar in the Map we have: pollFirstEntry, pollLastEntry
		
		System.out.println("treeSet.descendingSet()");
		System.out.println(treeSet.descendingSet());
		
		TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		treeMap.put(1,1);
		treeMap.put(2,2);
		treeMap.put(3,3);
		treeMap.put(4,4);
		treeMap.put(5,5);
		
		System.out.println("treeMap.descendingMap()");
		System.out.println(treeMap.descendingMap());
		
	}
	
	static void o(String s){
		System.out.println(s);
	}
}
