package trees.structures;

import java.util.LinkedList;
import java.util.Queue;

import searching.SearchType;
import trees.structures.BinarySearchTreeST.Node;

public class RedBlackTree<Key extends Comparable<Key>, Value> implements SearchType<Key, Value> {

	Node root;

	class Node {
		Key key;
		Value value;
		Node left, right;
		int size;
		boolean color;

		boolean isRed() {
			return color == true;
		}

		boolean isBlack() {
			return color == false;
		}

		Node(Key key, Value value, int size, boolean color) {
			this.key = key;
			this.value = value;
			this.size = size;
			this.color = color;
		}
	}

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			int size = size(node.left) + size(node.right) + 1;
			node.size = size;
			return size;
		}
	}

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.size = h.size;
		h.size = 1 + size(h.left) + size(h.right);
		return x;
	}

	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.size = h.size;
		h.size = 1 + size(h.left) + size(h.right);
		return x;
	}

	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	boolean isRed(Node node) {
		if (node == null)
			return false;
		return node.isRed();
	}

	@Override
	public void put(Key key, Value value) {
		root = put(root, new Node(key, value, 0, RED));
		root.color = BLACK;
	}

	private RedBlackTree<Key, Value>.Node put(Node root, Node node) {
		if (root == null)
			return node;
		int cmp = compare(node.key, root.key);
		if (cmp < 0) {
			root.left = put(root.left, node);
		} else if (cmp > 0) {
			root.right = put(root.right, node);

		} else {
			root.value = node.value;
		}
		if (!isRed(root.left) && isRed(root.right))
			root = rotateLeft(root);
		if (isRed(root.left) && isRed(root.left.left))
			root = rotateRight(root);

		if (isRed(root.right) && isRed(root.left)) {
			flipColors(root);
		}
		root.size = 1 + size(root.left) + size(root.right);
		return root;
	}

	int compare(Key key1, Key key2) {
		return key1.compareTo(key2);
	}

	@Override
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = compare(key, node.key);
		if (cmp < 0) {
			return get(node.left, key);
		} else if (cmp > 0) {
			return get(node.right, key);
		} else {
			return node.value;
		}
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	public void delete(Key key) {
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = delete(root, key);
		if (!isEmpty())
			root.color = BLACK;
	}

	private Node delete(Node h, Key key) {
		if (key.compareTo(h.key) < 0) {
			if (!isRed(h.left) && !isRed(h.left.left))
				h = moveRedLeft(h);
			h.left = delete(h.left, key);
		} else {
			if (isRed(h.left))
				h = rotateRight(h);
			if (key.compareTo(h.key) == 0 && (h.right == null))
				return null;
			if (!isRed(h.right) && !isRed(h.right.left))
				h = moveRedRight(h);
			if (key.compareTo(h.key) == 0) {
				h.value = get(h.right, min(h.right).key);
				h.key = min(h.right).key;
				h.right = deleteMin(h.right);
			} else
				h.right = delete(h.right, key);
		}
		return balance(h);
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return root != null ? root.size : 0;
	}

	@Override
	public Key min() {
		Node node = min(root);
		return node != null ? node.key : null;
	}

	private Node min(Node currentNode) {
		while (currentNode != null) {
			if (currentNode.left == null) {
				return currentNode;
			}
			currentNode = currentNode.left;
		}
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
		return rank(root, key, 0);
	}

	private int rank(Node node, Key key, int previousRank) {
		if (node == null) return -1;
		int currentRank = previousRank + (node.left != null ? node.left.size + 1 : 1);
		int cmp = compare(key, node.key);
		if (cmp < 0){
			return rank(node.left, key , previousRank);
		}else if (cmp > 0){
			return rank(node.right, key , currentRank);
		}else{
			return currentRank;
		}
	}

	@Override
	public Key select(int rank) {
		return select(root, rank, 0);
	}

	private Key select(Node node, int rank, int prevRanking) {
		if (node == null)
			return null;
		int currentRank = prevRanking + (node.left != null ? node.left.size + 1 : 1);
		if (currentRank == rank)
			return node.key;
		if (currentRank > rank) {
			return select(node.left, rank, prevRanking);
		} else {
			return select(node.right, rank, currentRank);
		}
	}

	private Node moveRedLeft(Node h) { // Assuming that h is red and both h.left
										// and h.left.left
										// are black, make h.left or one of its
										// children red.
		flipColors(h);
		if (isRed(h.right.left)) {
			h.right = rotateRight(h.right);
			h = rotateLeft(h);
		}
		return h;
	}

	public void deleteMin() {
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMin(root);
		if (!isEmpty())
			root.color = BLACK;
	}

	private Node deleteMin(Node h) {
		if (h.left == null)
			return null;
		if (!isRed(h.left) && !isRed(h.left.left))
			h = moveRedLeft(h);
		h.left = deleteMin(h.left);
		return balance(h);
	}

	private Node moveRedRight(Node h) { // Assuming that h is red and both
										// h.right and h.right.left
										// are black, make h.right or one of its
										// children red.
		flipColors(h);
		if (!isRed(h.left.left))
			h = rotateRight(h);
		return h;
	}

	public void deleteMax() {
		if (!isRed(root.left) && !isRed(root.right))
			root.color = RED;
		root = deleteMax(root);
		if (!isEmpty())
			root.color = BLACK;
	}

	private Node deleteMax(Node h) {
		if (isRed(h.left))
			h = rotateRight(h);
		if (h.right == null)
			return null;
		if (!isRed(h.right) && !isRed(h.right.left))
			h = moveRedRight(h);
		h.right = deleteMax(h.right);
		return balance(h);
	}

	private Node balance(Node h) {
		if (isRed(h.right))
			h = rotateLeft(h);
		return h;
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

	public Queue<Key> range(Key first, Key second){
		Queue<Key> queue = new LinkedList<>();
		range(queue, root, first, second);
		return queue;
	}
	
	private void range(Queue<Key> queue, Node node, Key first, Key second) {
		if (node == null) return;
		if (node.key.compareTo(first) > 0) range(queue, node.left, first, second);
		if (node.key.compareTo(first) >= 0 && node.key.compareTo(second) <=0){
			queue.add(node.key);
		}
		if (node.key.compareTo(second) < 0)range(queue, node.right, first, second);
	}

}
