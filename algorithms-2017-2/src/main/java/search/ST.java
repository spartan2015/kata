package search;

public interface ST<Key, Value> {
    void put(Key key, Value value);

    Value get(Key key);

    default void delete(Key key) {
        put(key, null);
    }

    ;

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Iterable<Key> keys();

}
