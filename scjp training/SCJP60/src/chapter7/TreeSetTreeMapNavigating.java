package chapter7;

import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetTreeMapNavigating {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// <Interface>NavigableSet methods:
		// higher ceil floor lower
		// headset, subset, tailset	 - fromElement- default inclusive, toElement=default EXclusive 
		// iterator, descendingIterator, descendingSet
		// first() last()
		// pollFirst(), pollLast()
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		System.out.println("set.first()[1] " + set.first());
		System.out.println("set.last()[4] " + set.last());
		// higher() - first element > parameters
		System.out.println("higher(3)[4] " + set.higher(3));
		// ceiling() - first element >= parameter
		System.out.println("ceiling(3)[3] " + set.ceiling(3));
		// first element <= parameter
		System.out.println("floor(3)[3] " + set.floor(3));
		// first element < parameter
		System.out.println("lower(3)[2] " + set.lower(3));
		
		System.out.println("headSet(3)[1,2] " + set.headSet(3));
		System.out.println("headSet(3,true)[1,2,3] " + set.headSet(3,true));
		System.out.println("tailSet(3)[3,4] " + set.tailSet(3));
		System.out.println("tailSet(3,false)[4] " + set.tailSet(3,false));
		
		System.out.println("subSet(2,3)[2] " + set.subSet(2, 3));
		System.out.println("subSet(2,true, 3,false)[2] " + set.subSet(2,true, 3,false));
		System.out.println("subSet(2,true, 3,true)[2,3] " + set.subSet(2,true, 3,true));
				
		System.out.println("set.pollFirst()[1],[2,3,4] " + set.pollFirst() + ", set: " + set);
		System.out.println("set.pollLast()[4],[2,3] " + set.pollLast() + ", set: " + set);
		
		
		// <Interface>NavigableMap methods
		/*
		 firstKey, firstEntry
		 lastKey, lastEntry
		 higherKey, higherEntry
		 ceilingKey, ceilingEntry
		 floorKey, floorEntry
		 lowerKey, lowerEntry
		 headMap
		 subMap
		 tailMap
		 pollFirstEntry
		 pollLastEntry		 
		*/
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		map.put(1,1);
		map.put(2,2);
		map.put(3,3);
		map.put(4,4);
		
		System.out.println("map.firstKey()[1] " + map.firstEntry());
		System.out.println("map.firstEntry()[1] " + map.firstEntry());
		
		System.out.println("map.lastKey()[4] " + map.lastKey());
		System.out.println("map.lastEntry()[4] " + map.lastEntry());
		
		System.out.println("map.higherKey(3)[4] " + map.higherKey(3));
		System.out.println("map.higherEntry(3)[4] " + map.higherEntry(3));
		
		System.out.println("map.ceilingKey(3)[3]" + map.ceilingKey(3));
		System.out.println("map.ceilingEntry(3)[3]" + map.ceilingEntry(3));
		
		System.out.println("map.floorKey(3)[3] " + map.floorKey(3));
		System.out.println("map.floorEntry(3)[3] " + map.floorEntry(3));
		
		System.out.println("map.lowerKey(3)[2] " + map.lowerKey(3));
		System.out.println("map.lowerEntry(3)[2] " + map.lowerEntry(3));
		
		System.out.println("map.headMap(3)[1,2]" + map.headMap(3));
		System.out.println("map.headMap(3,false)[1,2]" + map.headMap(3,false));
		System.out.println("map.headMap(3,true)[1,2,3]" + map.headMap(3,true));
		
		System.out.println("map.tailMap(3)[3,4] " + map.tailMap(3) );
		System.out.println("map.tailMap(3,true)[3,4] " + map.tailMap(3,true) );
		System.out.println("map.tailMap(3,false)[4] " + map.tailMap(3,false) );
		
		System.out.println("map.subMap(2,3)[2] " + map.subMap(2, 3));
		System.out.println("map.subMap(2,true, 3, false)[2] " + map.subMap(2,true, 3, false));
		System.out.println("map.subMap(2,true, 3, true)[2,3] " + map.subMap(2,true, 3, true));
		
		System.out.println("map.pollFirstEntry()[1=1]" + map.pollFirstEntry() + ", " + map);
		System.out.println("map.pollLastEntry()[4=4]" + map.pollLastEntry() + ", " + map);
	}

}
