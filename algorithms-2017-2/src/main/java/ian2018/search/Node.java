package ian2018.search;

/**
 * Created on 1/4/2018.
 */
public class Node<Key,Value> {
    Node<Key,Value> next;
    Key key;
    Value value;

    public Node(Node<Key, Value> next, Key key, Value value) {
        this.next = next;
        this.key = key;
        this.value = value;
    }

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}
