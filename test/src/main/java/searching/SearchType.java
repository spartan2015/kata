package searching;

import java.util.Queue;

public interface SearchType<Key extends Comparable<Key>, Value> {
	void put(Key key, Value value);
	Value get(Key key);
	boolean contains(Key key);
	void delete(Key key);
	boolean isEmpty();
	int size();
	Key min();
	Key max();
	Key floor(Key key);
	Key ceiling(Key key);
	int rank(Key key);
	Key select(int rank);
	void deleteMin();
	void deleteMax();
	int size(Key lo, Key hi);
	Iterable<Key> keys();
	Iterable<Key> keys(Key lo, Key hi);
	Queue<Key> range(Key first, Key second);
}
