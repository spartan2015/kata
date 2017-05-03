package collections;

import java.util.Iterator;

import collections.interfaces.Stack;

public class LinkedListStack<E> implements Stack<E> {
	int size;
	LinkedListNode<E> first;

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public void push(E e) {
		LinkedListNode<E> newNode = new LinkedListNode<>();
		newNode.item = e;
		newNode.next = first;
		first = newNode;
		size++;
	}

	@Override
	public E pop() {
		if (size != 0) {
			LinkedListNode<E> node = first;
			first = node.next;
			size--;
			return node.item;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
}