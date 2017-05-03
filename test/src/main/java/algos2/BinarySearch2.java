package algos2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearch2 {

	@Test
	public void t1() {
		assertTrue(0 == binarySearch(new int[] { 0, 1, 2, 3, 4, 5 }, 0));
		assertTrue(1 == binarySearch(new int[] { 0, 1, 2, 3, 4, 5 }, 1));
		assertTrue(2 == binarySearch(new int[] { 0, 1, 2, 3, 4, 5 }, 2));
		assertTrue(3 == binarySearch(new int[] { 0, 1, 2, 3, 4, 5 }, 3));
		assertTrue(4 == binarySearch(new int[] { 0, 1, 2, 3, 4, 5 }, 4));
		assertTrue(5 == binarySearch(new int[] { 0, 1, 2, 3, 4, 5 }, 5));

	}

	public int binarySearch(int[] array, int value) {

		int lo = 0;
		int hi = array.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (value < array[mid]) {
				hi = mid - 1;
			} else if (value > array[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
