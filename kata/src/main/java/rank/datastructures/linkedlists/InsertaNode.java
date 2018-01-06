package rank.datastructures.linkedlists;

/**
 * /challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
 */
public class InsertaNode {
    public static void main(String[] args) {

    }

    Node Insert(Node head,int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) return newNode;

        Node insertPoint = head;
        while(insertPoint.next!=null) insertPoint =insertPoint.next;
        insertPoint.next = newNode;

        return head;
    }

    class Node {
        int data;
        Node next;
    }
}
