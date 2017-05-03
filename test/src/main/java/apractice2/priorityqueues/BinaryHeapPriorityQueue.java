package apractice2.priorityqueues;

import java.util.Comparator;

public class BinaryHeapPriorityQueue<T extends Comparable<T>> implements PQ<T> {
	private Object[] data;
	private int size;
	private Comparator<T> comparator;

	public BinaryHeapPriorityQueue(int size) {
		data = new Object[size + 1];
	}

	public BinaryHeapPriorityQueue(int size, Comparator<T> comparator) {
		data = new Object[size + 1];
		this.comparator = comparator;
	}

	@Override
	public void insert(T element) {
		extendIfNeeded(size + 1);
		data[size + 1] = element;
		pushUp(size + 1);
		size++;
	}

	private void pushUp(int n) {
		if (n == 1)
			return;
		int p = parent(n);
		if (less((T) data[n], (T) data[p])) {
			swap(n, p);
			pushUp(p);
		}
	}

	private void swap(int n, int p) {
		Object tmp = data[n];
		data[n] = data[p];
		data[p] = tmp;
	}

	private boolean less(T v, T w) {
		if (comparator != null) {
			return comparator.compare(v, w) < 0;
		} else {
			return v.compareTo(w) < 0;
		}
	}

	private int parent(int n) {
		return n / 2;
	}

	private void extendIfNeeded(int size) {
		if (size > data.length - 1) {
			Object[] tmp = data;
			data = new Object[size * 2];
			for (int i = 0; i < size; i++) {
				data[i] = tmp[i];
			}
		}
	}

	@Override
	public T remove() {
		T tmp = (T) data[1];
		data[1] = data[size];
		data[size] = null;
		size--;
		pushDown(1);
		return tmp;
	}

	private void pushDown(int n) {
		if (n >= size) {
			return;
		}
		int c = 2 * n;
		while (c <= size && less((T) data[c], (T) data[n])) {
			if (c < size && less((T) data[c + 1], (T) data[n])) {
				swap(n, c);
				c++;
			} else {
				swap(n, c);
			}
			n = c;
		}
	}

	@Override
	public T peek() {
		return (T) data[1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

}
