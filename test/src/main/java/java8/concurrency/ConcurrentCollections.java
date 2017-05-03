package java8.concurrency;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ConcurrentCollections {

	@Test
	public void overview() {

		ConcurrentMap<String, String> map;
		map = new ConcurrentHashMap<>();
		map = new ConcurrentSkipListMap<>();

		Deque<String> deque;
		deque = new ConcurrentLinkedDeque<>();
		deque = new LinkedBlockingDeque<>();

		Queue<String> queue;
		queue = new ConcurrentLinkedQueue<>();
		queue = new LinkedBlockingQueue<>();

		Set<String> set;
		set = new ConcurrentSkipListSet<>();
		set = new CopyOnWriteArraySet<>();

		List<String> list;
		list = new CopyOnWriteArrayList<>();

	}

	@Test
	public void synchronizedCollections() {
		Collection collection = new ArrayList();
		Collection synchronizedCollection = Collections.synchronizedCollection(collection);
		
		List list = new ArrayList();
		List synchronizedList = Collections.synchronizedList(list);
		
		Set set = new HashSet();
		Set synchronizedSet = Collections.synchronizedSet(set);
		
		Map map = new HashMap();
		Map synchronizedMap = Collections.synchronizedMap(map);
		
		TreeSet treeSet = new TreeSet();
		SortedSet synchSortedSet = Collections.synchronizedSortedSet(treeSet);
		NavigableSet synchTreeSet = Collections.synchronizedNavigableSet(treeSet);
			
		TreeMap treeMap = new TreeMap();
		SortedMap synchSortedMap = Collections.synchronizedSortedMap(treeMap);
		NavigableMap synchTreeMap = Collections.synchronizedNavigableMap(treeMap);
		
		// REMEMBER: the iterator created by these synch collections is NOT synchronized
		// therefore synchronized usage if needed - in a for each loop or with an iterator
	}

	private int timeout = 1;
	private TimeUnit unit = TimeUnit.SECONDS;

	@Test
	public void blockingQueue() {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();

		try {
			queue.offer("a", 1, TimeUnit.SECONDS);
			queue.offer("b", 1, TimeUnit.SECONDS);
			queue.offer("c", 1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			assertEquals("a", queue.poll(1, TimeUnit.SECONDS));
			assertEquals("b", queue.poll(1, TimeUnit.SECONDS));
			assertEquals("c", queue.poll(1, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void blockingDeque() {
		BlockingDeque<String> deque = new LinkedBlockingDeque<>();
		deque.offerFirst("a");
		try {
			deque.offerFirst("1", timeout, unit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		deque.offerLast("b");
		try {
			deque.offerLast("c", timeout, unit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String result = deque.poll();
		try {
			result = deque.poll(timeout, unit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		result = deque.pollFirst();
		try {
			result = deque.pollFirst(timeout, unit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		result = deque.pollLast();
		try {
			result = deque.pollLast(timeout, unit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void skipList() {
		// concurrent TreeSet
		ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();
		SortedSet sortedSet = set;
		NavigableSet navigableSet = set;
		// concurrent TreeMap
		ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
		SortedMap sortedMap = map;
		NavigableMap navigableMap = map;

	}

	@Test
	public void copyOnWrite() {
		CopyOnWriteArrayList list = new CopyOnWriteArrayList<>();
		CopyOnWriteArraySet set = new CopyOnWriteArraySet<>();
	}
	
	@Test
	public void concurrentHashMap(){
		ConcurrentHashMap<String, Map<String, Boolean>> map = new ConcurrentHashMap<>();
		Map<String, Boolean> map2 = new ConcurrentHashMap<>();
		map2.put("map2Val",Boolean.TRUE);
		
		map.put("va", map2);		
		
		
		Map<String, Boolean> map3 = new ConcurrentHashMap<>();
		map.merge("va", map3, (oldMap,newMap)->{
			assertEquals(oldMap, map2);
			assertEquals(newMap, map3);
			return oldMap;
		});
		
		
	}
	

}
