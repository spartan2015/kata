package apractice2.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import sedgewick.StdRandom;

public class Quick3Way {
	@Test
	public void test() {
		Comparable[] ar = new Comparable[] { 7, 7, 6, 5, 4, 3, 2, 1, 1 };
		sort(ar);
		System.out.println(Arrays.toString(ar));
		assertTrue(isSorted(ar));
	}
	
	@Test
	public void test2() {
		Comparable[] ar = new Comparable[] { 3, 2, 1, 1 };
		
		sort(ar);
		System.out.println(Arrays.toString(ar));
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
	 * first 3 way quicksort was slower than classic quicksort - but a better
	 * quick 3 way was developed that is faster than mergesort for inputs with
	 * many duplicates with mathematical proof *
	 * 
	 * It is far more efficient than the standard
quicksort implementation for arrays with large numbers of duplicate keys (see text).
	 * 
	 * 
	 * ~ (2ln 2) N H compares to
sort N items, where H is the Shannon entropy, defined from the frequencies of key
values.
	H = lg N when the keys are all distinct (prob 1/N)
	
	it reduces the time of the sort from linearithmic to linear for arrays with
large numbers of duplicate keys.

	 * @param ar
	 */
	public static void sort(Comparable[] ar) {
		StdRandom.shuffle(ar); // N
		System.out.println(Arrays.toString(ar));
		int lo = 0;
		int hi = ar.length - 1;
		sort(ar, lo, hi);
	}

	private static void sort(Comparable[] ar, int lo, int hi) {
//		if (hi <= lo + 15) {
//			InsertionSort.sort(ar);
//			return;
//		}
		if (hi <=lo) return;
				
		int lt = lo;
		int i = lo + 1;
		int gt = hi;
		while (i <= gt) {
			int cmp = ar[i].compareTo(ar[lt]); // notice this differs from Sedgewick - p 299
			if (cmp < 0) {
				swap(ar, lt, i);
				lt++;
				i++;
			} else if (cmp > 0) {
				swap(ar, gt, i);
				gt--;
			} else {
				i++;
			}
		}
		sort(ar, lo, lt - 1);
		sort(ar, gt +1 , hi);
	}


	private static void swap(Comparable[] ar, int i, int j) {
		Comparable tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
}
