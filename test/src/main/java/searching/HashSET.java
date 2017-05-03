package searching;

public class HashSET<Key extends Comparable<Key>> implements SET<Key> {

	LinearProbingHashST<Key, Object> hashST = new LinearProbingHashST<>();
	Object voidObject = new Object();

	@Override
	public void add(Key key) {
		hashST.put(key, voidObject);
	}

	@Override
	public void delete(Key key) {
		hashST.delete(key);
	}

	@Override
	public boolean contains(Key key) {
		return hashST.contains(key);
	}

	@Override
	public boolean isEmpty() {
		return hashST.isEmpty();
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
	public void deleteMin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Key floor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceiling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key select(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
