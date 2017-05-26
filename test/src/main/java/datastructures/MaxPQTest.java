package datastructures;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * 14.01.2017
 * 
 * @author vasil
 *
 */
public class MaxPQTest {
	@Test
	public void test() {
		String[] initialList = new String[] { "a", "b", "c", "d" };
		MaxPQ max = new MaxPQ(initialList);
		IntStream.rangeClosed(0, initialList.length - 1).forEach(i -> {
			System.out.println(max.removeMax());
		});
	}
}
/*
class MaxPQ<Key extends Comparable<Key>> {

	private Object[] store;
	int index = 1;

	public MaxPQ() {

	}

	public MaxPQ(int size) {
		store = new Object[size + 1];
	}

	public MaxPQ(Key[] initialList) {
		this(initialList.length + 1);
		Arrays.stream(initialList).forEach(key -> insert(key));
	}

	public void insert(Key key) {
		store[index] = key;
		pushUp(index);
		index++;
	}

	private void pushUp(int i) {
		while (i > 1 && less(i, i / 2)) {
			swap(i, i / 2);
			i /= 2;
		}
	}

	private void pushUpRecursive(int i) {
		int parent = i / 2;
		if (i > 1 && less(parent, i)) {
			swap(parent, i);
			pushUp(parent);
		}
	}

	public Key removeMax() {
		Key first = (Key) store[1];
		store[1] = store[--index];
		pushDown(1);
		return first;
	}

	private void pushDown1(int i) {
		if (i == index)
			return;
		int leftChild = i * 2;
		if (leftChild <= index && less(i, leftChild)) {
			swap(i, leftChild);
			pushDown(leftChild);
		} else {
			int rightChild = leftChild + 1;
			if (rightChild <= index && less(i, rightChild)) {
				swap(i, rightChild);
				pushDown(rightChild);
			}
		}
	}

	private void pushDown(int i) {
		int leftChild = i * 2;
		int rightChild = leftChild + 1;
		while (leftChild < index) {
			int j = leftChild;
			if (rightChild < index && less(leftChild, rightChild))
				j = rightChild;
			if (!less(i, j))
				break;
			swap(i, j);
			i = j;
		}
	}

	public Key maxKey() {
		return (Key) store[0];
	}

	boolean less(int i, int j) {
		return ((Key) store[i]).compareTo((Key) store[j]) < 0;
	}

	void swap(int i, int j) {
		Object tmp = store[i];
		store[i] = store[j];
		store[j] = tmp;
	}

}
*/