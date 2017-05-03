package algos2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SelectKthSmallest {

	@Test
	public void t2() {
		Integer[] array = new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Looking the %d \n", i);
			assertEquals(Integer.valueOf(i), select(array, i));
		}
	}

	@Test
	public void test() {
		Integer[] array = new Integer[] { 19, 45, 15, 39 };

		// select(array,1);
		// select(array,2);
		// select(array,3);
		// select(array,4);
		assertEquals(Integer.valueOf(15), select(array, 1));
		assertEquals(Integer.valueOf(19), select(array, 2));
		assertEquals(Integer.valueOf(39), select(array, 3));
		assertEquals(Integer.valueOf(45), select(array, 4));
	}

	public <T extends Comparable<T>> T select(T[] array, int k) {
		int hi = array.length - 1;
		int lo = 0;
		while (hi >= lo) {
			int i = partition(array, lo, hi);
			if (i + 1 < k)
				lo = i + 1;
			else if (i + 1 > k)
				hi = i - 1;
			else if (k == i + 1)
				return array[i];
		}
		return array[k - 1];
	}

	int counter = 0;

	private <T extends Comparable<T>> int partition(T[] array, int lo, int hi) {
		T middleVal = array[lo];
		int i = lo + 1;
		int j = hi;
		System.out.printf("Partitioning: middle: %d, lo: %d, hi: %d \n", middleVal, lo, hi);
		System.out.println("b" + Arrays.toString(array));
		while (true) {
			while (i <= hi && less(array[i], middleVal)) {
				i++;
				System.out.println("i is " + i);
				if (i == j)
					break;
			}
			;
			while (j >= lo && less(middleVal, array[j])) {
				j--;
				System.out.println("j is " + j);
				if (j < i)
					break;
			}
			;
			if (i >= j)
				break;
			swap(array, i, j);
		}
		if (less(array[j], array[lo]))
			swap(array, lo, j);
		
		System.out.println("Returning: " + j);
		return j;
	}

	private <T extends Comparable<T>> void swap(T[] array, int i, int j) {
		counter++;
		if (counter == 100) {
			System.exit(1);
		}
		System.out.printf("swap %d with %d \n", array[i], array[j]);
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		System.out.println("a" + Arrays.toString(array));
	}

	private <T extends Comparable<T>> boolean less(T first, T second) {
		System.out.printf("Less: %d then %d \n", first, second);
		return first.compareTo(second) < 0;
	}

}
