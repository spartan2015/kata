package trees.structures;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import searching.SearchType;

public class BinarySearchTreeST<Key extends Comparable<Key>, Value> implements SearchType<Key, Value> {
	private Node root;

	class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		int countChildNodes;

		Node(Key key, Value value, int countChildNodes) {
			this.key = key;
			this.value = value;
			this.countChildNodes = countChildNodes;
		}
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			int size = size(node.left) + size(node.right) + 1;
			node.countChildNodes = size;
			return size;
		}
	}

	@Override
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node node, Key key, Value value) {
		if (node == null) {
			return new Node(key, value, 1);
		}
		int cmp = compare(key,node.key);
		if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else if (cmp > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}
		root.countChildNodes = size(root.left) + size(root.right) + 1;
		return node;
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
		int cmp = compare(key,node.key);
		if (cmp < 0) {
			return get(node.left, key);
		} else if (cmp > 0) {
			return get(node.right.key);
		} else {
			return node.value;
		}
	}

	@Override
	public boolean contains(Key key) {
		return get(key)!=null;
	}

	@Override
	public void delete(Key key) {
		delete(root,key);
	}

	private void delete(Node node, Key key) {
		if (node == null) return;
		Node parent = node;
		Node leaf = node;
		boolean left = true;
		while(leaf != null){
			int cmp = compare(key, leaf.key);
			if (cmp<0){
				parent = leaf;
				leaf = leaf.left;
				left =true;
			}else if (cmp > 0 ){
				parent = leaf;
				leaf = leaf.right;
				left = false;
			}else{
				if (leaf.right!=null || leaf.left != null){
					// successor find smallest key in the right
					Node successor = min(leaf.right);
					deleteMin(leaf.right);
					if (left){
						parent.left = successor;
					}else{
						parent.right = successor;
					}
					if (successor != leaf.right){
						successor.right = leaf.right;
					}
					successor.left = leaf.left;
				}else if(leaf.right == null){
					if (left){
						parent.left = leaf.left;
					}else{
						parent.right = leaf.left;
					}
				}else if(leaf.left == null){
					if (left){
						parent.left = leaf.right;
					}else{
						parent.right = leaf.right;
					}
				}
				else{
					if (left){
						parent.left = null;
					}else{
						parent.right = null;
					}
				}
			}
		}
		parent.countChildNodes = size(parent.left) + size(parent.right) + 1;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return size(root);
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
		Node currentNode = root;
		while (currentNode != null) {
			if (currentNode.right == null) {
				return currentNode.key;
			}
			currentNode = currentNode.right;
		}
		return null;
	}

	@Override
	public Key floor(Key key) {
		Node previousNode = root;
		Node currentNode = root;
		while (currentNode != null) {
			int cmp = compare(key,currentNode.key);
			previousNode = currentNode;
			if (cmp < 0) {
				currentNode = currentNode.left;
			} else if (cmp > 0) {
				currentNode = currentNode.right;
			} else {
				return currentNode.key;
			}
		}
		return previousNode != null & previousNode.key.compareTo(key) <=0 ? previousNode.key : null;
	}

	@Override
	public Key ceiling(Key key) {
		Node previousNode = root;
		Node currentNode = root;
		while (currentNode != null) {
			int cmp = compare(key,currentNode.key);
			previousNode = currentNode;
			if (cmp < 0) {
				currentNode = currentNode.left;
			} else if (cmp > 0) {
				currentNode = currentNode.right;
			} else {
				return currentNode.key;
			}
		}
		return previousNode != null & previousNode.key.compareTo(key)>=0 ? previousNode.key : null;
	}

	@Override
	public int rank(Key key) {
		return rank(root, key, 0);
	}

	private int rank(Node node, Key key, int previousRank) {
		if (node == null) return -1;
		int currentRank = previousRank + (node.left != null ? node.left.countChildNodes + 1 : 1);
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
		if (node == null) return null;
		int currentRank = prevRanking + (node.left != null ? node.left.countChildNodes+1:1);
		if (currentRank == rank) return node.key;
		if (currentRank > rank){
			return select(node.left, rank, prevRanking);
		}else{
			return select(node.right, rank, currentRank);
		}
	}

	@Override
	public void deleteMin() {
		deleteMin(root);
	}

	private void deleteMin(Node node) {
		if (node == null) return;
		Node parent = node;
		Node previousNode = node;
		Node currentNode = node.left;
		while(currentNode != null){
			parent = previousNode;
			previousNode = currentNode;
			currentNode = currentNode.left;
		}
		if (previousNode == root){
			root = previousNode.right;
		}else{
			parent.left = previousNode.right;
		}
		root.countChildNodes = size(root.left) + size(root.right) + 1;
		System.out.println("deleted " + previousNode.key);
	}

	@Override
	public void deleteMax() {
		deleteMax(root);
	}

	private void deleteMax(Node node) {
		if (node == null) return;
		Node parent = null;
		Node previousNode= null;
		Node currentNode = node;
		while(currentNode != null){
			parent = previousNode;
			previousNode = currentNode;
			currentNode = currentNode.right;
		}
		if (root == previousNode){
			root = previousNode.left;
		}else{
			parent.right = previousNode.left;
		}
		if (root!=null)root.countChildNodes = size(root.left) + size(root.right) + 1;
		System.out.println("delMax " + previousNode.key);
	}

	@Override
	public int size(Key lo, Key hi) {
		return 0;
	}

	@Override
	public Iterable<Key> keys() {
		return null;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		return range(lo,hi);
	}

	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
	public void inOrderTraversal(Node node){
		if(node == null) return;
		inOrderTraversal(node.left);
		System.out.println(node.value);
		inOrderTraversal(node.right);
	}
	
	public Queue<Key> range(Key first, Key second){
		Queue<Key> queue = new LinkedList<>();
		range(queue, root, first, second);
		return queue;
	}
	
	private void range(Queue<Key> queue, BinarySearchTreeST<Key, Value>.Node node, Key first, Key second) {
		if (node == null) return;
		if (node.key.compareTo(first) > 0) range(queue, node.left, first, second);
		if (node.key.compareTo(first) >= 0 && node.key.compareTo(second) <=0){
			queue.add(node.key);
		}
		if (node.key.compareTo(second) < 0)range(queue, node.right, first, second);
	}

	BinarySearchTreeST<Integer, Integer> bst = null;
	
	@Before
	public void before(){
		bst = new BinarySearchTreeST<>();
		bst.put(6,6);
		bst.put(5,5);
			bst.put(1,1);
			bst.put(2,2);
		bst.put(10,10);
			bst.put(8,8);
			bst.put(13,13);
	
	}
	
	@Test
	public void range(){
		assertTrue(bst.range(5,8).equals(Arrays.asList(5,6,8)));
		assertTrue(bst.range(1,5).equals(Arrays.asList(1,2,5)));
	}
	
	@Test
	public void traverse(){
		bst.inOrderTraversal();
	}
	
	@Test
	public void test() {
		
		assertNull(bst.ceiling(14));		
		assertEquals(Integer.valueOf(13), bst.ceiling(13));
		assertEquals(Integer.valueOf(13), bst.ceiling(12));
		assertEquals(Integer.valueOf(8), bst.ceiling(7));
		
		assertNull(bst.floor(0));
		//assertEquals(Integer.valueOf(1), bst.floor(1));
		//assertEquals(Integer.valueOf(2), bst.floor(2));
		//assertEquals(Integer.valueOf(2), bst.floor(3));
		
		
		assertEquals(Integer.valueOf(1), bst.select(1));
		assertEquals(Integer.valueOf(2), bst.select(2));
		assertEquals(Integer.valueOf(5), bst.select(3));
		assertEquals(Integer.valueOf(6), bst.select(4));
		assertEquals(Integer.valueOf(8), bst.select(5));
		assertEquals(Integer.valueOf(10), bst.select(6));
		assertEquals(Integer.valueOf(13), bst.select(7));
		
		//assertEquals(Integer.valueOf(1), (Integer)bst.rank(1));
		assertEquals(Integer.valueOf(2), (Integer)bst.rank(2));
		assertEquals(Integer.valueOf(3), (Integer)bst.rank(5));
		assertEquals(Integer.valueOf(4), (Integer)bst.rank(6));
		assertEquals(Integer.valueOf(5), (Integer)bst.rank(8));
		assertEquals(Integer.valueOf(6), (Integer)bst.rank(10));
		assertEquals(Integer.valueOf(7), (Integer)bst.rank(13));
		
		
		bst.deleteMax();
		bst.deleteMax();
		bst.deleteMax();
		bst.deleteMax();
		bst.deleteMax();
		bst.deleteMax();
		bst.deleteMax();
		
		bst.deleteMin();
		bst.deleteMin();
		bst.deleteMin();
		bst.deleteMin();
		bst.deleteMin();
		bst.deleteMin();
		bst.deleteMin();
	}
}
