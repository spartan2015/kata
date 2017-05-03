package datastructures;

import static org.junit.Assert.*;

import java.util.logging.Logger;

public interface PriorityQueue<T extends Comparable> {

	void add(T element);

	T poll();
	
	T peek();

}

class ArrayPriorityQueue<T extends Comparable> implements PriorityQueue<T> {

	private static Logger log = Logger.getLogger(ArrayPriorityQueue.class.getSimpleName());
	
	Object[] storage;
	int size = 0;
	
	public ArrayPriorityQueue(int capacity){
		storage = new Object[capacity];
	}
	
	/* (non-Javadoc)
	 * @see algos.PriorityQueue#add(T)
	 */
	@Override
	public void add(T element){
		if (size >= storage.length) {
			throw new RuntimeException("no room for more elements !");
		}	
		log.info("adding element: " + element);
		storage[size++] = element;
		pushUp(size-1);		
	}
	
	/* (non-Javadoc)
	 * @see algos.PriorityQueue#poll()
	 */
	@Override
	public T poll(){		
		if (size == 0) return null;
		swap(0,--size);
		Object ret = storage[size];
		storage[size] = null;
		log.info("removing element " + ret);
		pushDown(0);
		return (T)ret;
	}
	private void swap(int first, int second){
		log.info("swap " + storage[first] + " with " + storage[second]);
		Object temp = storage[first];
		storage[first]=storage[second];
		storage[second]=temp;
	}
	
	private int parent(int k){		
		if (k == 0) return 0;
		int parent = 0;
		if ((k+1) % 2 == 1) parent = ((k+1)-1)/2;
		else parent = (k+1)/2;
		
		log.info("parent of " + k + " is " + parent);
		
		return parent-1;
	}
	
	private void pushUp(int k){
		log.info("pushUp " + k);
		if (k == 0) return;
		int parent = parent(k);
		if (priority(k, parent)){
			swap(k, parent);
			pushUp(parent);
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean priority(int first, int second){		
		if (((T)storage[first]).compareTo((T)storage[second]) < 0){
			log.info(storage[first] + " has priority over " + storage[second]);
			return true;
		}else{
			log.info(storage[first] + " has NO priority over " + storage[second]);
			return false;
		}
	}
	
	private int left(int k){
		return (2*(k+1)-1);
	}
	
	private int right(int k){
		return (2*(k+1) + 1)-1;
	}
	
	private void pushDown(int k){
		log.info("pushDown " + k);
		if (k == size) return;
		
		int left = left(k);
		int right = right(k);
		
		if (right < size && storage[right] != null && priority(right,k)){
			swap(k,right);
			pushDown(right);
		} else if (left < size && storage[left] != null && priority(left,k)){
			swap(k, left);
			pushDown(left);
		} 
	}

	@Override
	public T peek() {		
		return (T)storage[0];
	}
	
}


