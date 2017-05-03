package datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPriorityQueue{
	@Test
	public void addTwoElementsTest(){
		PriorityQueue<Integer> pq = new ArrayPriorityQueue<>(2);
		pq.add(2);
		pq.add(1);
		
		assertEquals(Integer.valueOf(1), pq.peek());
		assertEquals(Integer.valueOf(1), pq.poll());
		assertEquals(Integer.valueOf(2), pq.poll());
	}
	
	@Test
	public void addThreeElementsTest(){
		PriorityQueue<Integer> pq = new ArrayPriorityQueue<>(3);
		pq.add(3);
		pq.add(2);
		pq.add(1);
		
		assertEquals(Integer.valueOf(1), pq.peek());		
		assertEquals(Integer.valueOf(1), pq.poll());
		assertEquals(Integer.valueOf(2), pq.poll());
		assertEquals(Integer.valueOf(3), pq.poll());
	}
	
	@Test
	public void addThreeElementsRemoveFirstTest(){
		PriorityQueue<Integer> pq = new ArrayPriorityQueue<>(4);
		pq.add(2);
		pq.add(3);
		pq.add(4);
		pq.add(1);
				
		assertEquals(Integer.valueOf(1), pq.peek());
		assertEquals(Integer.valueOf(1), pq.poll());
		assertEquals(Integer.valueOf(2), pq.poll());
		assertEquals(Integer.valueOf(3), pq.poll());
		assertEquals(Integer.valueOf(4), pq.poll());		
	}
	
}