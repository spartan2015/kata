package sort;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SelectionSort {

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
	 * Perfomance ~(N^2) / 2 - (n-1) + (n-2) + .. 3 + 2+ 1 = (n(n-1)) / 2
	 * 
	 * Running time is insensitive to input.
	 * Data movement is minimal. BEST on min exchanges
	 * 
	 * @param ar
	 */
	public static void sort(Comparable[] ar) {
		for (int i = 0; i < ar.length; i++) {
			int min = i;
			for (int j = i + 1; j < ar.length; j++) {
				if (less(ar[j], ar[min])) {
					min = j;
				}
			}
			swap(ar, i, min);
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
