package rank.datastructures.linkedlists;

/**
 * challenges/delete-a-node-from-a-linked-list/problem
 */
public class DeleteaNode {
    public static void main(String[] args) {

    }

    Node Delete(Node head, int position) {
        if (position == 0) return head.next;
        Node before = head;
        for (int i = 0; i < position - 1; i++) {
            before = before.next;
        }
        before.next = before.next.next;
        return head;
    }

    class Node {
        int data;
        Node next;
    }

}
