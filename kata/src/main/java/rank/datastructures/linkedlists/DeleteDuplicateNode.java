package rank.datastructures.linkedlists;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
 */
public class DeleteDuplicateNode {
    Node RemoveDuplicates(Node head) {
        Node current = head;
        while(current!=null){
            while (current.next != null && current.next.data == current.data){
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }

    @Test
    public void c1(){
        assertTrue(Node.build(1,2,3,4).equals(RemoveDuplicates(Node.build(1,1,2,2,3,4,4))));
        assertTrue(Node.build(1).equals(RemoveDuplicates(Node.build(1,1,1,1,1,1,1,1))));
    }
}
