package searching;

public interface SET<Key extends Comparable<Key>> {
	void add(Key key);
	void delete(Key key);
	boolean contains(Key key);
	boolean isEmpty();
	int size();
	Key min();
	Key max();
	void deleteMin();
	void deleteMax();
	Key floor();
	Key ceiling();
	int rank(Key key);
	Key select(int i);
}
