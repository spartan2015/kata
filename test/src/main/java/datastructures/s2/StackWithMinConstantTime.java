package datastructures.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackWithMinConstantTime<E extends Comparable<E>> {
	Node<E> head;
	
	static class Node<T extends Comparable<T>>{
		Node<T> next;
		T value;
		T min;
		Node(T t, T min){
			this.value= t;
			this.min = min;
		}		 
	}
	
	public void push(E e){
		E min = head != null ? e.compareTo(head.min) < 0 ? e : head.min : e;
		Node<E> newNode = new Node<>(e,min);
		newNode.next = head;
		head = newNode;
	}
	
	public E pop(){
		if (head == null) return null;
		E tmp = head.value;
		head = head.next;
		return tmp;
	}
	
	public E min(){
		if (head == null) return null;
		return head.min;
	}

 	@Test
	public void test(){
		StackWithMinConstantTime<Integer> s = new StackWithMinConstantTime<Integer>();
		s.push(3);
		s.push(4);
		s.push(2);
		s.push(5);
		
		assertEquals(Integer.valueOf(2), s.min());
		assertEquals(Integer.valueOf(5), s.pop());
		assertEquals(Integer.valueOf(2), s.pop());
		assertEquals(Integer.valueOf(3), s.min());
		assertEquals(Integer.valueOf(4), s.pop());
		assertEquals(Integer.valueOf(3), s.pop());
		assertNull(s.pop());
		assertNull(s.min());
	}
}