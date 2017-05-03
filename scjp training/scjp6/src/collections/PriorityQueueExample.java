package collections;

import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(1);
		q.offer(2); // same as add
		
		System.out.println(q.peek()); // retrieves only the first element

		System.out.println(q.poll()); // retrieves and REMOVES the first element - same as
		System.out.println(q);
			
	}

}
