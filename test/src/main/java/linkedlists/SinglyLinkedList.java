package linkedlists;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SinglyLinkedList {

	public LinkedListNode delete(LinkedListNode head, Object data) {
		if (head == null)
			return null;
		if (head.data.equals(data)) {
			return head.next;
		}
		LinkedListNode current = head;
		while (current.next != null) {
			if (current.next.data.equals(data)) {
				current.next = current.next.next;
				return head;
			}
			current = current.next;
		}
		return head;
	}

	@Test
	public void testDeleteDuplicates() {
		LinkedListNode head = new LinkedListNode("a");
		head.addToTail("b");
		head.addToTail("b");
		head.addToTail("b");
		head.addToTail("b");
		head.addToTail("b");
		head.addToTail("b");
		head.addToTail("z");
		head.addToTail("z");
		head.addToTail("z");

		deleteDuplicatesAgain(head);
		System.out.println(head);
	}

	public void deleteDuplicatesAgain(LinkedListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		LinkedListNode parent = head;
		LinkedListNode nodeToCheck = head;
		while ((nodeToCheck = nodeToCheck.next) != null) {
			boolean deleteHappened = false;
			LinkedListNode current = head;
			do {
				if (current.data.equals(nodeToCheck.data)) {
					parent.next = nodeToCheck.next;
					deleteHappened = true;
					break;
				}
			} while (current.next != nodeToCheck && (current = current.next) != null);
			if (!deleteHappened) {
				parent = nodeToCheck;
			}
		}
	}

	@Test
	public void testNthToLastElement() {
		LinkedListNode head = new LinkedListNode(1);
		head.addToTail(2);
		head.addToTail(3);
		head.addToTail(4);
		head.addToTail(5);
		head.addToTail(6);

		assertEquals(Integer.valueOf(5), nthToLastElement(head, 2));
	}

	@Test
	public void testNthToLastElementRecursive() {
		LinkedListNode head = new LinkedListNode(1);
		head.addToTail(2);
		head.addToTail(3);
		head.addToTail(4);
		head.addToTail(5);
		head.addToTail(6);

		assertEquals(Integer.valueOf(3), nthToLastElementRecursive(head, 4)[0]);
		assertEquals(Integer.valueOf(4), nthToLastElementRecursive(head, 3)[0]);
		assertEquals(Integer.valueOf(5), nthToLastElementRecursive(head, 2)[0]);
	}

	public Object[] nthToLastElementRecursive(LinkedListNode node, int n) {
		if (node.next == null) {
			return new Object[] { node.data, 1 };
		} else {
			Object[] result = nthToLastElementRecursive(node.next, n);
			Integer prevValue = (Integer) result[1];
			if (prevValue == n) {
				return result;
			} else {
				return new Object[] { node.data, prevValue + 1 };
			}
		}
	}

	@Test
	public void deleteNodeInMiddleOfList() {
		LinkedListNode head = new LinkedListNode("a");
		head.addToTail("b");
		head.addToTail("c");

		deleteNodeInMiddle(head.next);
		System.out.println(head);
	}

	private void deleteNodeInMiddle(LinkedListNode node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}

	@Test
	public void testAddTwoNumbersRepresentedAsLinkedList() {
		LinkedListNode<Integer> first = new LinkedListNode<>(1);
		first.addToTail(8);
		first.addToTail(2); // 281

		LinkedListNode<Integer> second = new LinkedListNode<>(3);
		second.addToTail(3);
		second.addToTail(9); // 933 = 414

		LinkedListNode<Integer> sumList = sumOfLinkedList(first, second);
		System.out.println(sumList);
	}

	private LinkedListNode<Integer> sumOfLinkedList(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		// assume same size
		LinkedListNode<Integer> p1 = first;
		LinkedListNode<Integer> p2 = second;

		LinkedListNode<Integer> sumList = null;
		boolean addOneMore = false;
		do {
			int sum = p1.data + p2.data;
			if (addOneMore) {
				sum++;
				addOneMore = false;
			}
			if (sum > 10)
				addOneMore = true;
			if (sumList == null) {
				sumList = new LinkedListNode<>(sum % 10);
			} else {
				sumList.addToTail(sum % 10);
			}
			p1 = p1.next;
			p2 = p2.next;
		} while (p1 != null);
		if (addOneMore) {
			sumList.addToTail(1);
		}
		return sumList;
	}

	@Test
	public void circularLinkedList() {
		LinkedListNode head = new LinkedListNode("a");
		head.addToTail("b");
		head.addToTail("c");
		head.addToTail("d");
		head.addToTail("e");
		LinkedListNode c = head.next.next;
		head.next.next.next.next.next = c;

		assertTrue(isCircular(head));
		assertTrue(isCircularDiffSpeeds(head));
	}

	private boolean isCircular(LinkedListNode head) {
		if (head == null || head.next == null)
			return false;
		LinkedListNode mainNode = head;
		int mainNodeCount = 1;
		do {
			LinkedListNode checkWith = head;
			int secondNodeCount = 1;
			do {
				if (checkWith == mainNode) {
					if (mainNodeCount != secondNodeCount){
						System.out.println(checkWith);
						return true;
					}
					break;
				}
				secondNodeCount++;
			} while ((checkWith = checkWith.next) != null);
			
			mainNodeCount++;
		} while ((mainNode = mainNode.next) != null);

		return false;
	}

	private boolean isCircularDiffSpeeds(LinkedListNode head) {
		LinkedListNode n1 = head;
		LinkedListNode n2 = head;
		while(n2.next!=null){
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2) break;
		}
		System.out.println("met at: " + n2);
		if (n2 == null){
			return false;
		}
		n1 = head;
		while(n1!=n2){
			n1 = n1.next;
			n2 = n2.next;
		}
		System.out.println("loop start " +  n2);
		return true;
	}
	
	public Object nthToLastElement(LinkedListNode head, int n) {
		if (head == null)
			return null;
		List<Object> list = new ArrayList();
		LinkedListNode current = head;
		do {
			list.add(current.data);
		} while ((current = current.next) != null);
		return list.get(list.size() - n);
	}

	public void deleteDuplicates(LinkedListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		LinkedListNode lastUnique = head;
		LinkedListNode next = head;
		while ((next = next.next) != null) {
			lastUnique = unique(head, lastUnique, next);
		}
		lastUnique.next = null;
	}

	private LinkedListNode unique(LinkedListNode head, LinkedListNode lastUnique, LinkedListNode nextNode) {
		if (head.data.equals(nextNode.data)) {
			return lastUnique;
		}
		LinkedListNode current = head;
		while ((current = current.next) != null) {
			if (current == nextNode) {
				return nextNode;
			} else if (current == lastUnique) {
				if (nextNode.data.equals(current.data)) {
					return lastUnique;
				} else {
					lastUnique.next = nextNode;
					return nextNode;
				}
			} else if (current.data.equals(nextNode.data)) {
				return lastUnique;
			}
		}
		lastUnique.next = current;
		return current;
	}

}
