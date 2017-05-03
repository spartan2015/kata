package datastructures.s2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackBasedOnLinkedList<E> {

	Node<E> head;
	int count;

	static class Node<T> {
		Node<T> next;
		T value;

		Node(T val) {
			this.value = val;
		}
	}

	public void push(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		count++;
	}
	
	public E pop(){
		if (head == null) return null;
		Node<E> tmp = head;
		head= head.next;
		count--;
		return tmp.value;
	}
	
	@Test
	public void test(){
		StackBasedOnLinkedList<Integer> s = new StackBasedOnLinkedList<>();
		s.push(1);
		s.push(2);
		s.push(3);
		assertEquals(Integer.valueOf(3),s.pop());
		assertEquals(Integer.valueOf(2),s.pop());
		assertEquals(Integer.valueOf(1),s.pop());
		assertNull(s.pop());
	}
}
