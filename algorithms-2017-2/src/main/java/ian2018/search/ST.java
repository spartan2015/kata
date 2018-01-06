package ian2018.search;

/**
 * Created on 1/3/2018.
 *
 * key must not be null
 * value not null - put with null will delete the key
 * single value per key
 * put replaces existing
 */
public interface ST<Key,Value> extends Iterable<Key> {
    void put(Key key, Value value);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
    Iterable<Key> keys();
}
