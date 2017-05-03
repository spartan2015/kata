package linkedlists.s2;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedlists.LinkedListNode;

public class RemoveDuplicates {

	@Test
	public void setupSimple() {
		LinkedListNode<Integer> root = LinkedListNode.create(1, 1, 1);
		root = removeDupes(root);

		assertNotNull(root);
		assertNull(root.next);
		assertTrue(1 == root.data);
	}
	
	@Test
	public void test2() {
		LinkedListNode<Integer> root = LinkedListNode.create(1, 1, 1,2 );
		root = removeDupes(root);

		assertNotNull(root);
		assertTrue(1 == root.data);
		assertTrue(2 == root.next.data);
	}
	
	@Test
	public void test3() {
		LinkedListNode<Integer> root = LinkedListNode.create(1, 1, 1,2 ,2);
		root = removeDupes(root);

		assertNotNull(root);
		assertTrue(1 == root.data);
		assertTrue(2 == root.next.data);
		assertNull(root.next.next);
	}

	public LinkedListNode<Integer> removeDupes(LinkedListNode<Integer> root) {
		if (root == null){
			return null;
		}
		LinkedListNode node = root;
		while (node.next != null) {
			if (!isUnique(node.next.data, root, node)) {
				node.next = node.next.next;
				continue;
			}
			node = node.next;
		}
		return root;
	}

	private boolean isUnique(Object data, LinkedListNode<Integer> root, LinkedListNode<Integer> lastNode) {
		LinkedListNode<Integer> node = root;
		if (node.data.equals(data)) {
			return false;
		}
		if (root == lastNode) {
			return true;
		}
		while (node.next != null) {
			if (node.next.data.equals(data)) {
				return false;
			}
			if (node.next == lastNode) {
				return true;
			}
			node = node.next;
		}
		return true;
	}

}
