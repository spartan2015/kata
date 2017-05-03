package searching;

import java.util.Queue;

public class LinearProbingHashST<Key extends Comparable<Key>, Value> implements SearchType<Key, Value> {

	Key[] keys;
	Value[] values;
	int size;
	int N;
	int M ;

	public LinearProbingHashST() {
		this(16);
	}
	public LinearProbingHashST(int M) {
		this.M = M;
		keys = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
	}

	private int hash(Key x) {
		int t = x.hashCode() & 0x7fffffff;
		return t % M;
	}

	@Override
	public void put(Key key, Value value) {
		if (N >= M / 2)
			resize(2 * M); // double M (see text)
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		keys[i] = key;
		values[i] = value;
		N++;
	}

	private void resize(int cap) {
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<Key, Value>(cap);
		for (int i = 0; i < M; i++)
			if (keys[i] != null)
				t.put(keys[i], values[i]);
		keys = t.keys;
		values = t.values;
		M = t.M;
	}

	@Override
	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key))
				return values[i];
		return null;
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public void delete(Key key) {
		if (!contains(key))
			return;
		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i + 1) % M;
		keys[i] = null;
		values[i] = null;
		resetNextEntriesPositionInTheHashMap(i);
		shrinkIfNeeded();
	}

	private void shrinkIfNeeded() {
		if (N > 0 && N == M / 8)
			resize(M / 2);
	}

	private void resetNextEntriesPositionInTheHashMap(int i) {
		i = (i + 1) % M;
		while (keys[i] != null) {
			Key keyToRedo = keys[i];
			Value valToRedo = values[i];
			keys[i] = null;
			values[i] = null;
			N--;
			put(keyToRedo, valToRedo);
			i = (i + 1) % M;
		}
		N--;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key select(int rank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Queue<Key> range(Key first, Key second) {
		// TODO Auto-generated method stub
		return null;
	}
}
