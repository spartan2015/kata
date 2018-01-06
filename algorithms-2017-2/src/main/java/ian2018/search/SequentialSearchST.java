package ian2018.search;

import java.util.Iterator;

/**
 * Created on 1/4/2018.
 */
public class SequentialSearchST<Key,Value> extends AbstractST<Key,Value>{

    Node<Key,Value> head;

    @Override
    public void put(Key key, Value value) {
        Node<Key,Value> current = head;
        do{
            if (current!=null){
                if (current.key.equals(key)){
                    current.value = value;
                    return;
                }
            }else{
                break;
            }
        }while((current = current.next)!=null);

        head = new Node<Key, Value>(head,key,value);
    }

    public void put2(Key key, Value value){
        for(Node current = head; current!=null; current=current.next){
            if (sameKey(key, current)){
                current.value=value;
                return;
            }
        }
        head = new Node<Key, Value>(head,key,value);
    }

    @Override
    public Value get(Key key) {
        Node<Key,Value> current = head;
        while( current !=null && notTheSame(key, current) && (current = current.next)!=null);
        return current != null ? current.value : null;
    }

    public Value get2(Key key) {
        for(Node<Key,Value> current = head; current != null; current = current.next){
            if (sameKey(key,current)){
                return current.value;
            }
        }
        return null;
    }

    private boolean notTheSame(Key key, Node<Key, Value> current) {
        return !current.key.equals(key);
    }

    private boolean sameKey(Key key, Node<Key, Value> current) {
        return current.key.equals(key);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }
}
