package linkedlists.s2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import linkedlists.LinkedListNode;

public class CycleDetection {

	@Test
	public void detectCycleTest() {
		LinkedListNode<Integer> root = LinkedListNode.create(1, 2, 3, 4, 5);

		LinkedListNode<Integer> n3 = root.next.next;
		LinkedListNode<Integer> n5 = root.next.next.next.next;
		n5.next = n3;

		assertTrue(detectCycle(root) != null);
		assertTrue(detectCycle(root).data == 3);
	}

	private LinkedListNode<Integer> detectCycle(LinkedListNode<Integer> root) {
		LinkedListNode n1 = root;
		LinkedListNode n2 = root;
		if (root == root.next)
			return root;
		while (n2.next != null && n2.next.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2)
				break;
		}
		if (n1 != n2)
			return null;

		n1 = root;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}

		return n1;
	}

}
