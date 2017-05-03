package apractice2.priorityqueues.test;

import static org.junit.Assert.*;

import org.junit.Test;

import apractice2.priorityqueues.BinaryHeapPriorityQueue;

public class PQTest {
	@Test
	public void test() {
		BinaryHeapPriorityQueue<Integer> pq = new BinaryHeapPriorityQueue<>(10);
		pq.insert(3);
		assertTrue(3 == pq.peek());
		pq.insert(2);
		assertTrue(2 == pq.peek());
		pq.insert(1);
		assertTrue(1 == pq.peek());
		
		assertTrue(1 == pq.remove());
		assertTrue(2 == pq.remove());
		assertTrue(3 == pq.remove());
	}
}
