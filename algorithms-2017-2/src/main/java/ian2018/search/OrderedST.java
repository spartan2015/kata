package ian2018.search;

/**
 * Created on 1/4/2018.
 */
public interface OrderedST<Key extends Comparable<Key>, Value> {
    void put(Key key, Value value);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
    Key min();
    Key max();
    Key floor(Key key);
    Key ceiling(Key key);
    /*
    find the number of keys less than given key
    i == rank(select(i))
    key == select(rank(key))
     */
    int rank(Key key);
    Key select(int k);
    void deleteMin();
    void deleteMax();
    int size(Key lo, Key hi);
    Iterable<Key> keys(Key lo, Key hi);
    Iterable<Key> keys();
}
