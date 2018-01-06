package rank.datastructures.linkedlists;

/**
 * Created on 12/7/2017.
 */
public class GetNodeValue {

    int GetNode(Node head, int n) {

        Node newList = new Node();
        newList.data = head.data;

        Node current = head;
        while ((current = current.next) != null) {
            Node node = new Node();
            node.data = current.data;
            node.next = newList;
            newList = node;
        }

        int position = 0;
        current = newList;

        if (n == 0) return current.data;

        while ((current = current.next) != null) {
            position++;
            if (position == n) {
                return current.data;
            }
        }
        return -1;
    }
}
