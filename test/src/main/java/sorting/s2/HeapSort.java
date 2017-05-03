package sorting.s2;

import java.util.Arrays;

import org.junit.Test;

public class HeapSort {

	@Test
	public void fixIt() {
		int[] array = {0 ,3,2,1};
		sort(array);
	}

	void sort(int[] array) {
		for (int k = array.length / 2 ; k >= 1; k--) {
			sink(array, k, array.length);
		}
		System.out.println("phase 2");
		for(int k = array.length-1; k>1;){ // sedgewick was wrong to decrement after swap and before sink - should be done after both ops - but why does this cause an extra swap ?
			swap(array,1,k); // swap largest with with last - largest will be last - skip largest for next iterations 
			sink(array,1,k);//bring front the largest
			k--;
		}
	}

	void sink(int[] array, int i, int N) {
		while (i*2 < N) {
			int leftChild = i * 2;
			int rightChild = leftChild + 1;
			int j = leftChild;
			if (rightChild < N && less(array, leftChild, rightChild)) {
				j = rightChild;
			}
			if (!less(array, i, j))
				break;
			swap(array, i, j);			
			i = j;
		}
	}

	void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		System.out.println(Arrays.toString(array));
	}

	boolean less(int[] array, int i, int j) {
		return array[i] < array[j];
	}
}
