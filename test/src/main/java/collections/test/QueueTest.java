package collections.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

public class QueueTest {

	@Test
	public void t1() {

		Queue<Integer> queue = new PriorityQueue<>();

		queue.add(1); //[1] throws Exception on capacity violation: 
		boolean offered = queue.offer(2); //[1,2] same as add but returns boolean instead of throwing an exception
		queue.offer(3);//[1,2,3] - ADD LAST semantics - but in a priority queue it will reorder everything
		queue.offer(4);//[1,2,3,4] - ADD LAST semantics - but in a priority queue it will reorder everything
		queue.offer(5);//[1,2,3,4,5] - ADD LAST semantics - but in a priority queue it will reorder everything
		
		
		Integer r = queue.remove(); // retrieves and removes the head - should throw and NoSuchElementException
		assertEquals(Integer.valueOf(1), r);		
		r = queue.poll(); // same as remove but does not throw exception, instead it returns null		
		assertEquals(Integer.valueOf(2), r);
		
		try{
			queue.element(); // returns but keeps the head of the collection throws NoSuchElementException
			throw new RuntimeException("should throw exception");
		}catch(Exception ex){
			//ok
		}
		queue.peek(); // same but no exception, instead returns null
		
		// implementations
		LinkedList<Integer> linkedList = new LinkedList<>(); // queue (double ended) and list semantics but not as efficient 
		ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(); // same as linked list but efficient - pure double ended queue
		
		
		// Deque extends Queue - NOT SORTED - IT IS LIKE A STACK
		Deque deque = new ArrayDeque(); // NOT sorted, just ordered - 
		deque.push(1);//addFirst - at the HEAD 1
		deque.push(2);//addFirst - at the HEAD 2 1
		deque.push(3);//addFirst - at the HEAD 3 2 1
		deque.push(4);//addFirst - at the HEAD 4 3 2 1
		deque.push(5);//addFirst - at the HEAD 5 4 3 2 1
				
		try{
			assertEquals(Integer.valueOf(5),deque.pop()); // 4 3 2 1 same as remove and poll - more like Remove since it throws exception - 
			
			assertEquals(Integer.valueOf(4),deque.poll()); // 3 2 1 removed FIRST element - 4 in this case
			throw new RuntimeException("should throw exception");
		}catch(Exception ex){
			//ok
		}
		
				
		// Stack LinkedList and Queue work about the same, Stack is based on ArrayDeque, LinkedList is a less efficient ArrayDeque
		// LIFO - pop
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);	// [1]
		stack.push(2); //[2,1]
		assertEquals(Integer.valueOf(2), stack.peek());
		stack.push(3); // [3,2,1]
		assertEquals(Integer.valueOf(3), stack.peek());
		
		assertEquals(Integer.valueOf(3), stack.pop());
	}
	
	@Test
	public void tmap(){
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new LinkedHashMap<>();
		Map<Integer, Integer> map3 = new TreeMap<>();
				
		map1.clear();
		
		boolean t = map1.isEmpty();
		
		int size = map1.size();
		
		map1.put(1, 1);
		
		Integer key = Integer.valueOf(1);
		
		Integer r = map1.get(key);
		
		Integer r1 = map1.remove(key);
		
		boolean t1 = map1.containsKey(key);
		
		Integer value = Integer.valueOf(2);
		
		boolean t2 = map1.containsValue(value);
		
		Set<Integer> keySet = map1.keySet();
		
		Collection<Integer> values = map1.values();
		
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(1,1);
		treeMap.put(1,1);//overwrites same key maybe new value
		
		/**
		 * no null allowed: 
		 * TreeMap keys
		 * Hashtable keys and values
		 * TreeSet
		 * ArrayDeque 
		 */
	}

}
