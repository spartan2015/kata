package collections.test;

import java.util.Iterator;
import java.util.stream.IntStream;

import org.junit.Test;

import collections.BasicQueue;
import collections.LinkedListStack;
import collections.ArrayStack;
import collections.interfaces.Stack;

public class CollectionsTest {

	@Test
	public void testSimpleStack() {
		ArrayStack<Integer> ss = new ArrayStack<Integer>(100);
		IntStream.range(0, 1000).forEach(e -> ss.push(e));

		IntStream.range(0, 1000).forEach(e -> ss.pop());
	}

	@Test
	public void testLinkedList() {
		Stack<Integer> ss = new LinkedListStack<>();
		IntStream.range(0, 10).forEach(e -> ss.push(e));

		IntStream.range(0, 10).forEach(e -> System.out.println(ss.pop()));
	}

	@Test
	public void testBasicQueue() {
		BasicQueue<Integer> ss = new BasicQueue<>();
		IntStream.range(0, 10).forEach(e -> ss.enqueue(e));

		Iterator<Integer> iterator = ss.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		IntStream.range(0, 10).forEach(e -> System.out.println(ss.dequeue()));
	}
}
