package rank.datastructures.linkedlists;

/**
 * challenges/insert-a-node-at-the-head-of-a-linked-list/problem
 */
public class InsertAtHead {

    class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {

    }


    Node Insert(Node head,int x) {
        Node newNode = new Node();
        newNode.data = x;

        newNode.next=head;
        return newNode;
    }
}
