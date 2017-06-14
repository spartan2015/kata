package search;

import java.util.Iterator;

public class SequentialSearchST<Key, Value> implements ST<Key, Value> {

	static class Node<Key, Value> {
		Key key;
		Value value;
		Node<Key, Value> next;

		Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
		}
	}

	Node<Key, Value> root;
	int size = 0;

	/**
	 * inserting N elements takes N^2/2 complexity. Precisely n(n+1)/2
	 *
	 * @param key
	 * @param value
	 */
	public void put2(Key key, Value value) {
		for(Node node = root; node!=null; node = node.next){
			if (node.key.equals(key)){
				node.value = value; // update
				return;
			}
		}
		size++;
		root = new Node(key,value,root); // add
	}

	@Override
	public void put(Key key, Value value) {
		Node<Key, Value> parent = null;
		Node<Key, Value> currentNode = root;
		boolean found = false;
		while (currentNode != null) {
			if (currentNode.key.equals(key)) {
				found = true;
				if (value == null) { // deleting
					if (currentNode == root){
						root = currentNode.next;
					}else{
						parent.next = currentNode.next;
					}
					size--;
				}else {
					currentNode.value = value;
				}
				break;
			}
			parent = currentNode;
			currentNode = currentNode.next;
		}

		if (!found && value !=null) {
			root = new Node<Key, Value>(key, value, root);
			size++;
		}
	}

	/**
	 * N complexity
	 *
	 * @param key
	 * @return
	 */
	public Value get2(Key key) {
		for(Node<Key,Value> node = root; node!=null; node = node.next){
			if (node.key.equals(key)){
				return node.value;
			}
		}
		return null;
	}

	@Override
	public Value get(Key key) {
		Node<Key, Value> currentNode = root;
		while (currentNode != null) {
			if (currentNode.key.equals(key)) {
				return currentNode.value;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	@Override
	public void delete(Key key) {
		Node<Key, Value> previousNode = null;
		Node<Key, Value> currentNode = root;
		while (currentNode != null) {
			if (currentNode.key.equals(key)) {
				size--;
				if (previousNode == null) {
					root = currentNode.next;
				} else {
					previousNode.next = currentNode.next;
				}
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
	}

	@Override
	public boolean contains(Key key) {
		return get(key)!=null;
	}

	@Override
	public boolean isEmpty() {
		return size() != 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterable<Key> keys() {
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				return new Iterator<Key>() {
					Node<Key,Value> next=root;

					@Override
					public boolean hasNext() {
						if (next != null){
							next = next.next;
						}
						return next!=null;
					}

					@Override
					public Key next() {
						return next.key;
					}
				};
			}
		};
	}

}
