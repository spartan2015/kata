package searching;

import java.util.Queue;

public class SequentialSearchST<Key extends Comparable<Key>, Value> implements SearchType<Key, Value> {

	Node first;
	int count = 0;

	class Node {
		Key key;
		Value value;
		Node next;

		Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}

	@Override
	public void put(Key key, Value value) {
		Node newNode = new Node(key, value);
		for(Node currentNode = first; currentNode!=null; currentNode = currentNode.next){
			if (currentNode.key.compareTo(key)==0){
				currentNode.value = value;
				return;
			}
		}		
		newNode.next = first;
		first = newNode;
		count++;
	}

	@Override
	public Value get(Key key) {
		Node currentNode = first;
		while (currentNode != null) {
			if (currentNode.key.equals(key)) {
				return currentNode.value;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key select(int rank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Queue<Key> range(Key first, Key second) {
		// TODO Auto-generated method stub
		return null;
	}

}
