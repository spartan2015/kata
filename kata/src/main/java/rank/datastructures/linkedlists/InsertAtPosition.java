package rank.datastructures.linkedlists;

/**
 * Created on 12/5/2017.
 */
public class InsertAtPosition {
    class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {

    }

    Node InsertNth(Node head, int data, int position) {
        Node node = new Node();
        node.data = data;

        if (position == 0){
            node.next = head;
            head = node;
        }else{
            Node current = head;
            for(int i = 0; i <position-1; i++){
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }

        return head;
    }
}
