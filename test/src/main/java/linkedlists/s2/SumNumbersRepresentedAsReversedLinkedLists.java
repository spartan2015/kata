package linkedlists.s2;

import static org.junit.Assert.*;

import org.junit.Test;

import linkedlists.LinkedListNode;

public class SumNumbersRepresentedAsReversedLinkedLists {

	@Test
	public void setupSimple() {
		LinkedListNode<Integer> no1 = LinkedListNode.create(9, 2, 3);
		LinkedListNode<Integer> no2 = LinkedListNode.create(9, 2, 9);

		LinkedListNode<Integer> sum = sum(no1, no2);
		assertTrue(sum != null);
		assertTrue(sum.data == 8);
		assertTrue(sum.next.data == 5);
		assertTrue(sum.next.next.data == 2);
		assertTrue(sum.next.next.next.data == 1);
	}

	@Test
	public void setupSimple2() {
		LinkedListNode<Integer> no1 = LinkedListNode.create(1, 2, 3);
		LinkedListNode<Integer> no2 = null;

		LinkedListNode<Integer> sum = sum(no1, no2);
		assertNotNull(sum);
		assertTrue(sum.data == 1);
		assertTrue(sum.next.data == 2);
		assertTrue(sum.next.next.data == 3);
	}

	private LinkedListNode<Integer> sum(LinkedListNode<Integer> no1, LinkedListNode<Integer> no2) {
		if (no1 == null && no2 == null)
			return null;
		LinkedListNode<Integer> sumLinkedList = null;

		int addNext = 0;
		while (no1 != null || no2 != null) {

			int sum = getValue(no1) + getValue(no2);
			int currentValue = sum % 10;
			if (sumLinkedList == null) {
				sumLinkedList = new LinkedListNode<Integer>(currentValue + addNext);
			} else {
				sumLinkedList.addToTail(currentValue + addNext);
			}
			addNext = sum / 10;

			no1 = no1 != null ? no1.next : null;
			no2 = no2 != null ? no2.next : null;
		}
		
		if (addNext != 0) {
			sumLinkedList.addToTail(addNext);
		}

		return sumLinkedList;
	}

	private int getValue(LinkedListNode<Integer> no2) {
		if (no2 != null)
			return no2.data;
		return 0;
	}
}
