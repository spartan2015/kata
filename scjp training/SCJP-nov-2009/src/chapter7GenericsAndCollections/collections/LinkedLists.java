package chapter7GenericsAndCollections.collections;

import java.util.LinkedList;

public class LinkedLists {

	public static void main(String[] args) {

		/**
		 * elements are double linked to each other
		 * 
		 * good for STACK and QUEUE: peek(), poll(), offer() 
		 */
		
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.add("a");
		linkedList.add("b");
		linkedList.add("c");
		linkedList.add("d");
		
		System.out.println(		linkedList.poll()		); // retrievs and removes the first element of this list
		
		System.out.println(		linkedList.pollFirst()	); // SAME AS ABOVE
		
		
		System.out.println(		linkedList.pollLast()	);
		
		linkedList.offer("d"); // ADD LAST
		
		linkedList.offerLast("e"); // SAME AS ABOVE 
		System.out.println(linkedList);
		
		linkedList.offerFirst("a"); // ADD FIRST
		System.out.println(linkedList);
		
		
	}

}
