package chapter7.collections;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class PriorityQueueUsage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		
		pq.offer(1);
		pq.offer(2);
		pq.offer(3);
		
		System.out.println(pq.peek() + " = 3"); // HEAD
		System.out.println(pq.poll() + " = 3"); // HEAD
		

		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(set.pollLast()); // does not have poll - PriorityQueue.poll() == TreeSet.pollLast() - highest = HEAD of queue 
		
	}

}
