package sort;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MergeSortBottomUp {
	@Test
	public void test() {
		Comparable[] ar = new Comparable[] { 6, 5, 4, 3, 2, 1 };
		sort(ar);
		System.out.println(ar);
		assertTrue(isSorted(ar));
	}

	@Test
	public void test2() {
		Comparable[] ar = new Comparable[] { 7, 6, 5, 4, 3, 2, 1 };
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
	 * 
	 * uses extra spaces proportional with N - some variation improve much on
	 * this
	 * 
	 * improve with insertion sort for small arrays (less than 15)
	 * 
	 * test if the array is already in order
	 * 
	 * Eliminate the copy to the auxiliary array
	 * 
	 * bottom up: method of choice for sorting data organized in a linked list.
	 * 
	 * @param ar
	 */
	public static void sort(Comparable[] ar) {
		Comparable[] support = new Comparable[ar.length];
		sortBottomUp(ar, support);
	}

	private static void sortBottomUp(Comparable[] ar, Comparable[] support) {
		int size = 2;
		while (size / 2 < ar.length) {
			for (int i = 0; i < ar.length; i += size) {
				int lo = i;
				int hi = Math.min(ar.length - 1, i + size - 1);
				int mid = (lo + hi) / 2;
				merge(ar, support, lo, mid, mid + 1, hi);
			}
			size *= 2;
		}
	}

	private static void sortBottomUpMyComplicatedAttempt(Comparable[] ar, Comparable[] support) {
		int currentSize = 2;
		while (currentSize / 2 <= ar.length) {
			int lo = 0;
			int mid = currentSize / 2 - 1;
			int hi = Math.min(ar.length - 1, currentSize - 1);
			if (currentSize > 2) {
				for (int k = 2; k <= currentSize / 2; k++) {
					int secLo = mid + 1;
					int secHi = Math.min(ar.length - 1, secLo + k - 1);
					int secMid = (secLo + secHi) / 2;
					merge(ar, support, secLo, secMid, secMid + 1, secHi);
				}
			}
			merge(ar, support, 0, mid, mid + 1, hi);
			currentSize *= 2;
		}
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
