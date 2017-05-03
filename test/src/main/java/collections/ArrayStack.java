package collections;

import java.util.Iterator;

import collections.interfaces.Stack;

public class ArrayStack<E> implements Stack<E> {

	Object[] repo;
	int currentPosition;
	int size;

	public ArrayStack(int initialSize) {
		size = initialSize;
		repo = new Object[initialSize];
	}

	@Override
	public void push(E e) {
		if (currentPosition >= size - 1) {
			resize(2 * size);
		}
		repo[currentPosition++] = e;
	}

	@Override
	public E pop() {
		if (currentPosition - 1 == size / 4) {
			resize(size / 2);
		}
		E e = (E) repo[--currentPosition];
		repo[currentPosition] = null; // loitering
		return e;
	}

	private void resize(int newSize) {
		System.out.println(String.format("resize from %d to %d ", size, newSize));
		Object[] newRepo = new Object[newSize];
		for (int i = 0; i < currentPosition; i++) {
			newRepo[i] = repo[i];
		}
		repo = newRepo;
		size = newSize;
	}

	@Override
	public Iterator<E> iterator() {

		return new Iterator<E>() {
			int start = 0;

			@Override
			public boolean hasNext() {

				return start != size - 1;
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				return (E) repo[start++];
			}
		};
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