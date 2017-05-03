package collections.test;

import static org.junit.Assert.*;

import java.util.ArrayDeque;

import org.junit.Test;

public class ArrayDequeMethod {

	@Test
	public void test() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		deque.add(1);
		deque.add(2);
		deque.add(3);

		Integer firstElement = deque.element(); // return the first element of the queue - like peek -
							// only it throws an exception if the deque is empty
		assertTrue(1 == firstElement);
		deque.offer(4);
		
		Integer firstElementRemoved = deque.remove(); // removes and returns the first element
		assertTrue(1 == firstElementRemoved);
		
		deque.push(5); // add element at the front of the queue -- isn't this resorted like a PriorityQueue?		
		assertTrue(5 == deque.remove()); // nope, it is not sorted what if we add more
		deque.push(5);
		deque.add(6); // insert at the end
		assertTrue(5 == deque.remove()); // still the first element even if first should be 2...
		
		Integer removesFromList = deque.poll(); // like remove, returns and removes first element in the queue
		assertTrue(2 == removesFromList);
		
		Integer peek = deque.peek(); // show the first element in the queue
		Integer popFirst = deque.pop();// removes and returns next element or throws exception if empty queue
		
		
	}
	
	

}
