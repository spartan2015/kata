package linkedlists.s2;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedlists.LinkedListNode;

public class DeleteNodeWhileOnlyTheNodeIsGiven {
	@Test
	public void setupSimple() {
		LinkedListNode<Integer> root = LinkedListNode.create(1, 2, 3, 4, 5, 6);

		deleteNode(root.next.next);

		assertTrue(root.next.next.data == 4);
		assertTrue(root.next.next.next.data == 5);
		assertTrue(root.next.next.next.next.data == 6);
		assertTrue(root.next.next.next.next.next == null);
	}

	private void deleteNode(LinkedListNode<Integer> node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}
}
