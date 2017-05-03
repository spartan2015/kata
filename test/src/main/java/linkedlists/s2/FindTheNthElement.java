package linkedlists.s2;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedlists.LinkedListNode;

public class FindTheNthElement {

	@Test
	public void setupSimple() {
		LinkedListNode<Integer> root = LinkedListNode.create(1, 2, 3, 4, 5, 6);
		assertTrue(6 == find(root, 1).data);
		assertTrue(5 == find(root, 2).data);
		assertTrue(4 == find(root, 3).data);
		assertTrue(3 == find(root, 4).data);
		assertTrue(2 == find(root, 5).data);
		assertTrue(1 == find(root, 6).data);
	}

	private LinkedListNode<Integer> find(LinkedListNode<Integer> root, int i) {
		LinkedListNode<Integer> distanceNode = root;
		int count = 1;
		while (distanceNode.next != null && count < i) {
			distanceNode = distanceNode.next;
			count++;
		}
		
		if (count != i) {
			return null;
		}
		
		LinkedListNode<Integer> nthNode = root;
		while (distanceNode.next != null) {
			distanceNode = distanceNode.next;
			nthNode = nthNode.next;
		}
		return nthNode;
	}

}
