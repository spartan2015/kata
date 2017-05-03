package collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.offer("1");
		list.offer("2");
		
		System.out.println(list.poll() + " == pollFirst()");

	}

}
