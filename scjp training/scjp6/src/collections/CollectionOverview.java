package collections;

import java.util.ArrayList;
import java.util.*;

public class CollectionOverview {


	public static void main(String[] args) {
		
		List<String> list;
		
		list = new Vector<String>();
		list = new ArrayList<String>();
		list = new LinkedList<String>();
		
		System.out.println(list instanceof Collection);
		
		
		Set<String> set;		
		set = new HashSet();
		set = new LinkedHashSet();
		set = new TreeSet();
		// SortedSet
		// NavigableSet
		
		System.out.println(set instanceof Collection);
		
		Queue queue;
		queue = new LinkedList();
		queue = new PriorityQueue();
		
		System.out.println(queue instanceof Collection);
		
		
		Map map;
		map = new Hashtable();
		map = new HashMap();
		map = new LinkedHashMap();
		map = new TreeMap();
		// SortedMap
		// NavigableMap
		System.out.println((map instanceof Collection) + " = FALSE");
		
		
	}
}
