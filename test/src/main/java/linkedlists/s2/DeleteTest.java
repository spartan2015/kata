package linkedlists.s2;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedlists.LinkedListNode;

public class DeleteTest {

	public LinkedListNode<Integer> setupSimple() {
		LinkedListNode<Integer> root = new LinkedListNode<Integer>(1);
		root.addToTail(2);
		root.addToTail(3);
		return root;
	}

	@Test
	public void testDeleteRoot() {
		LinkedListNode<Integer> root = setupSimple();
		root = deleteNode(root, 1);
		assertTrue(2==root.data);
	}
	
	@Test
	public void testDeleteLast() {
		LinkedListNode<Integer> root = setupSimple();
		root = deleteNode(root, 3);
		assertTrue(1==root.data);
		assertTrue(2==root.next.data);
	}
	
	@Test
	public void testDeleteMiddle() {
		LinkedListNode<Integer> root = setupSimple();
		root = deleteNode(root, 2);
		assertTrue(1==root.data);
		assertTrue(3==root.next.data);
	}

	private <T> LinkedListNode<T> deleteNode(LinkedListNode<T> root, T i) {
		if (root.data==i) return root.next;
		LinkedListNode<T> parent = root;
		LinkedListNode<T> next = root;
		while((next = next.next)!=null){
			if (next.data.equals(i)){
				parent.next=next.next;
				break;
			}
			parent = next;
		}
		return root;
	}

}
