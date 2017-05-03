package apractice2.priorityqueues;

public interface PQ<T extends Comparable<T>> {
	void insert(T element);
	T remove();
	T peek();
	int size();
	boolean isEmpty();
}
