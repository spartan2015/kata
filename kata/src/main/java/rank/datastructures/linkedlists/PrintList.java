package rank.datastructures.linkedlists;

/**
 * /challenges/print-the-elements-of-a-linked-list/problem
 */
public class PrintList {
    public static void main(String[] args) {


    }

    void Print(Node head) {
        if (head== null) return;
        System.out.println(head.data);
        Print(head.next);

    }

    static class Node {
        int data;
        Node next;
    }

}
