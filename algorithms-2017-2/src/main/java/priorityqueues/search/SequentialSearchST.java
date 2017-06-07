package priorityqueues.search;

public class SequentialSearchST<Key, Value> implements ST<Key, Value> {

	static class Node<Key, Value> {
		Key key;
		Value value;
		Node<Key, Value> next;

		Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}

	Node<Key, Value> root;
	int size = 0;

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
			Node<Key, Value> newNode = new Node<Key, Value>(key, value);
			size++;
			if (root != null) {
				newNode.next = root;
				root = newNode;
			} else {
				root = newNode;
			}
		}
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

}