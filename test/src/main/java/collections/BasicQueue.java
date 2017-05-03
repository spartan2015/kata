package collections;

import java.util.Iterator;

import collections.interfaces.Queue;

public class BasicQueue<E> implements Queue<E> {

	int size;
	LinkedListNode<E> first;
	LinkedListNode<E> last;

	@Override
	public Iterator<E> iterator() {			
		return new Iterator<E>(){
			LinkedListNode<E> current = first;

			@Override
			public boolean hasNext() {					
				return current != null;
			}

			@Override
			public E next() {
				E item = current.item;
				current = current.next;
				return item;
			}
			
		};
	}

	@Override
	public void enqueue(E e) {
		LinkedListNode<E> node = new LinkedListNode<>();
		node.item = e;
		if (last == null) {
			first = node;
			last = node;
		} else {				
			last.next = node;
			last = node;
		}
		size++;
	}

	@Override
	public E dequeue() {
		if (first != null) {
			LinkedListNode<E> node = first;
			first = node.next;
			size--;
			return node.item;
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}