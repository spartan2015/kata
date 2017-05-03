package datastructures;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

public class MaxPQTest{
	@Test
	public void test(){
		String[] initialList = new String[]{"a","b","c","d"};
		MaxPQ max = new MaxPQ(initialList);

		IntStream.rangeClosed(0, initialList.length-1).forEach(i->{
			System.out.println(max.removeMax());;
		});
	}
}
class MaxPQ<Key extends Comparable<Key>> {

	
	
	private Object[] store;
	int index;
	public MaxPQ() {

	}

	public MaxPQ(int size) {
		store = new Object[size];
	}

	public MaxPQ(Key[] initialList) {
		this(initialList.length);
		Arrays.stream(initialList).forEach(key -> insert(key));
	}

	public void insert(Key key) {
		store[index++] = key;
		pushUp(index);
	}

	private void pushUp(int i) {
		if (i == 0) return;
		int parent = i / 2;
		if (less(parent,i)){
			swap(parent,i);			
		}
		pushUp(parent);
	}

	public Key removeMax() {
		Key first = (Key)store[0];
		store[0]=store[index--];
		pushDown(0);
		return first;
	}

	private void pushDown(int i) {
		if (i == index) return;
		if (less(i, i*2)){
			swap(i, i*2);
			pushDown(i*2);
		}else if (less(i, i*2+1)){
			swap(i, i*2+1);
			pushDown(i*2+1);
		}
		
	}

	public Key maxKey() {
		return (Key)store[0];
	}

	boolean less(int i, int j) {
		return ((Key) store[i]).compareTo((Key)store[j]) < 0;
	}
	
	void swap(int i, int j){
		Object tmp = store[i];
		store[i]=store[j];
		store[j]=tmp;
	}
}
