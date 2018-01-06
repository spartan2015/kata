package rank.datastructures.linkedlists;

/**
 * challenges/print-the-elements-of-a-linked-list-in-reverse/problem
 */
public class PrintinReverse {
    class Node {
        int data;
        Node next;
    }
    public static void main(String[] args) {

    }

    void ReversePrint(Node head) {
        if (head == null) return;
        ReversePrint(head.next);
        System.out.println(head.data);
    }
}
