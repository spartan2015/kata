package linkedlists;

import org.junit.Test;

public class ReverseLinkedList {

	
	@Test
	public void revTest(){
		LinkedListNode<String> root = new LinkedListNode<String>("a");
		root.addToTail("b").addToTail("c").addToTail("d");
		
		root = reverse(root);
		
		System.out.println(root);
	}

	private LinkedListNode<String> reverse(LinkedListNode<String> root) {
		LinkedListNode prev=root;
		LinkedListNode node = root.next;
		root.next = null;
		while(node!=null){
			LinkedListNode tmp = node.next;
			node.next = prev;
			prev= node;
			node = tmp;
		}
		return prev;
	}
}
