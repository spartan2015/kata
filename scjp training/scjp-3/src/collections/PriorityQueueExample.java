package collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(3);
		pq.offer(2);
		pq.offer(1);
		System.out.println("peek: " + pq.peek());
		System.out.println(pq);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
		System.out.println("inverse:");
		PriorityQueue<Integer> pq_inverse = new PriorityQueue<Integer>(5, new Comparator<Integer>(){
			@Override
			public int compare(Integer i1, Integer i2) {
				
				return i2.compareTo(i1);
			}
			
		});
		
		pq_inverse.add(1);
		pq_inverse.add(2);
		pq_inverse.add(3);
		System.out.println("peek: " + pq_inverse.peek());
		System.out.println(pq_inverse);
		
		System.out.println(pq_inverse.poll());
		System.out.println(pq_inverse.poll());
		System.out.println(pq_inverse.poll());
	}

}
