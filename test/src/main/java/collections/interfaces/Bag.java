package collections.interfaces;

interface Bag<E> extends Iterable<E> {
	void add(E e);

	int size();

	boolean isEmpty();

}