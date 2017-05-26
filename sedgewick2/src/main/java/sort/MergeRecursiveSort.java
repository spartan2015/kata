package sort;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MergeRecursiveSort {
	@Test
	public void test() {
		Comparable[] ar = new Comparable[] { 4, 3, 2, 1 };
		sort(ar);
		System.out.println(ar);
		assertTrue(isSorted(ar));
	}

	private static boolean isSorted(Comparable[] ar) {
		for (int i = 1; i < ar.length; i++) {
			if (less(ar[i], ar[i - 1])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * uses extra spaces proportional with N - some variation improve much on this
	 * 
	 * improve with insertion sort for small arrays (less than 15)
	 * 
	 * test if the array is already in order
	 * 
	 * Eliminate the copy to the auxiliary array
	 * 
	 * @param ar
	 */
	public static void sort(Comparable[] ar) {
		Comparable[] support = new Comparable[ar.length];
		sortRecursive(ar, support, 0, ar.length-1);
	}

	private static void sortRecursive(Comparable[] ar, Comparable[] support, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) >> 1;
		sortRecursive(ar, support, lo, mid);
		sortRecursive(ar, support, mid + 1, hi);
		merge(ar, support, lo, mid, mid + 1, hi);
	}

	private static void merge(Comparable[] ar, Comparable[] support, int lo, int mid, int mid1, int hi) {
		int i = lo;
		int j = mid1;
		for (int k = lo; k <= hi; k++) {
			support[k] = ar[k];
		}

		int index = lo;
		while (i < mid + 1 || j <= hi) {
			if (i > mid) {
				ar[index++] = support[j++];
			} else if (j > hi) {
				ar[index++] = support[i++];
			} else if (less(support[i], support[j])) {
				ar[index++] = support[i++];
			} else {
				ar[index++] = support[j++];
			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void swap(Comparable[] ar, int i, int j) {
		Comparable tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
	}
}
