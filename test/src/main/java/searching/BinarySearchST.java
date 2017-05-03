package searching;

import java.util.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements SearchType<Key, Value> {
	private Key[] keys;
	private Value[] values;
	private int currentIndex = 0;

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}

	@Override
	public void put(Key key, Value value) {
		if (value == null) {
			delete(key);
			return;
		}
		int where = rank(key);
		if (where < currentIndex && keys[where].compareTo(key) == 0) {
			values[where] = value;
			return;
		}
		if (where < currentIndex) {
			for (int i = currentIndex; i > where; i--) {
				keys[i] = keys[i - 1];
				values[i] = values[i - 1];
			}
		}
		keys[where] = key;
		values[where] = value;
		currentIndex++;
	}

	@Override
	public Value get(Key key) {
		int rank = rank(key);
		return keys[rank].compareTo(key) == 0 ? values[rank] : null;
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public void delete(Key key) {
		int rank = rank(key);
		if (keys[rank].compareTo(key) == 0) {
			deleteIndex(rank);
		}
	}

	private void deleteIndex(int rank) {
		for (int i = rank; i < currentIndex; i++) {
			keys[i] = keys[i + 1];
			values[i] = values[i + 1];
		}
		currentIndex--;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return currentIndex;
	}

	@Override
	public Key min() {
		return currentIndex > 0 ? keys[0] : null;
	}

	@Override
	public Key max() {
		return keys[currentIndex - 1];
	}

	@Override
	public Key floor(Key key) {
		int rank = rank(key);
		return key.compareTo(keys[rank]) == 0 ? keys[rank] : keys[rank - 1];
	}

	@Override
	public Key ceiling(Key key) {
		int rank = rank(key);
		return keys[rank];
	}

	@Override
	public int rank(Key key) {
		return rank(key, 0, currentIndex - 1);
	}

	private int rank(Key key, int i, int j) {
		if (i > j)
			return i;
		int middle = (i + j) / 2;
		int cmp = key.compareTo(keys[middle]);
		if (cmp < 0) {
			return rank(key, i, middle - 1);
		} else if (cmp > 0) {
			return rank(key, middle + 1, j);
		} else {
			return middle;
		}
	}

	@Override
	public Key select(int rank) {
		return rank <= currentIndex ? keys[rank - 1] : null;
	}

	@Override
	public void deleteMin() {
		if (size() > 0) {
			deleteIndex(0);
		}
	}

	@Override
	public void deleteMax() {
		if (size() > 0) {
			deleteIndex(currentIndex - 1);
		}
	}

	@Override
	public int size(Key lo, Key hi) {
		if (lo.compareTo(hi) > 0) {
			return 0;
		} else if (contains(lo)) {
			return rank(lo) - rank(hi) + 1;
		} else {
			return rank(lo) - rank(hi);
		}
	}

	@Override
	public Iterable<Key> keys() {
		return null;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		return null;
	}

	@Override
	public Queue<Key> range(Key first, Key second) {
		// TODO Auto-generated method stub
		return null;
	}

}