package rank.datastructures.linkedlists;

/**
 * Created on 12/5/2017.
 */
public class Reversealinkedlist {
    class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {

    }

    Node Reverse(Node head) {
        if (head == null) return null;

        Node newList = new Node();
        newList.data = head.data;

        Node current = head;
        while((current = current.next)!=null){
            Node node = new Node();
            node.data = current.data;
            node.next = newList;
            newList = node;
        }

        return newList;

    }
}
