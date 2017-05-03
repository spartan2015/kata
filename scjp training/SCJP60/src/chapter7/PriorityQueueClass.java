package chapter7;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueClass {
	
	public static void main(String[] args) {

		/**
		 * peek, poll, offer
		 */
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(2);
		pq.offer(1);
		pq.add(3);

		System.out.println(pq); 		// by default - natural order defines priority: 1,2,3
		
		// but you can define a comparator - to change the sort order - and the priorty 
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(10,new Comparator<Integer>(){
			public int compare(Integer i1, Integer i2){
				return i2.compareTo(i1);
			}
		});
		pq1.add(2);
		pq1.offer(1);
		pq1.add(3);
		
		while(!pq1.isEmpty()){
			System.out.print(pq1.poll() + ", ");
		}
		
		
	}

}
