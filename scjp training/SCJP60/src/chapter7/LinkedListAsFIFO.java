package chapter7;

import java.util.LinkedList;
import java.util.List;

public class LinkedListAsFIFO {

	
	public static void main(String[] args) {
		/*
		 * Linked list - slower to iterate - order by index and by last inserted
		 * - fast add/remove
		 * 
		 */
		
		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("one");
		ll.add("two");
		ll.add("three");
		
		// FIFO with pop - 
		while(ll.size() > 0)
			System.out.println(ll.pop());
		
		
		ll.add("one");
		ll.add("two");
		ll.add("three");
		
		//LIFO with linked list - pollLast() - possible with Stack too -
		while(ll.size() > 0)
			System.out.println(ll.pollLast());
		
		// pop = poll = pollFirst
		// offer(adauga la coada) = offerLast
		// offerFirst = push (adauga la inceput)
		
		/*
		 Adding:
		 add first:		push() == offerFirst() == addFirst()
		 add last:		add() == addLast() == offer() == offerLast()
	 
		 Removing and get:
		 	remove first:		pop() == poll() == pollFirst()
		 	remove last:		pollLast()		 
		 */
		
		ll.add("one");
		ll.add("two");
		ll.add("three");
				
		System.out.println("push() - add and element to the front of the list");
		ll.push("1");
		printer(ll);
		
		System.out.println("push() == offerFirst() == addFirst");
		ll.offerFirst("0");
		ll.addFirst("-1");
		printer(ll);
		
		System.out.println("offer() = offerLast() = add() = addLast() - add an element at the end of the list");
		ll.offer("4");
		ll.offerLast("5");
		ll.add("6");
		ll.addLast("7");
		printer(ll);
		
		System.out.println("peek() == getFirst() - View the first element");
		System.out.println(ll.peek() + " == " + ll.getFirst());
		
		System.out.println("getLast() - view the last element");
		System.out.println(ll.getLast());
	}
	
	static void printer(List<String> list){
		for(String s: list){
			System.out.println(s);
		}
		System.out.println("---");
	}

}
