package rank.datastructures.linkedlists;

/**
 * Created on 12/5/2017.
 */
public class Node {
    int data;
    Node next;

    Node(){}

    static Node build(int... is){
        Node head = null;
        Node prev = null;
        for(int i : is){
            Node node = new Node();
            node.data = i;
            if (head == null) head = node;
            if (prev!=null)
                prev.next = node;
            prev= node;
        }
        return head;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node){
            Node other = (Node)obj;
            if (1 == new CompareTwoLinkedLists().CompareLists(this, other)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
