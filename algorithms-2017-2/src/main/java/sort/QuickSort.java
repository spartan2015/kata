package sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class QuickSort {
	@Test
	public void test() {
		Comparable[] ar = new Comparable[] { 7, 7, 6, 5, 4, 3, 2, 1, 1 };
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
	 * worse case can be quadratic - shuffle before recommended
	 * 
	 * average case - better than any other (including merge)
	 * 
	 * small extra space required - optimal in this sense
	 * 
	 * @param ar
	 */
	public static void sort(Comparable[] ar) {
		//StdRandom.shuffle(ar); // N
		int lo = 0;
		int hi = ar.length - 1;
		sort(ar, lo, hi);
	}

	private static void sort(Comparable[] ar, int lo, int hi) {
		if (hi <= lo + 15) {
			InsertionSort.sort(ar);
			return;
		}

		int p = partition(ar, lo, hi);
		sort(ar, lo, p - 1);
		sort(ar, p + 1, hi);
	}

	/**
	 * The crux of the method is the partitioning process, which rearranges the
	 * array to make the following three conditions hold: ■ ====> The entry a[j]
	 * is in its fi nal place in the array, for some j. <=== ■ No entry in a[lo]
	 * through a[j-1] is greater than a[j]. ■ No entry in a[j+1] through a[hi]
	 * is less than a[j].
	 * 
	 * Hoare partitioning method See also Lomuto partitioning method - less
	 * efficient but valid
	 * 
	 * Properly testing whether the pointers have crossed is a bit trickier than
	 * it might seem at first glance. A common error is to fail to take into
	 * account that the array might contain other items with the same key value
	 * as the partitioning item
	 * 
	 * It is best to stop the left scan for items with keys greater than or
	 * equal to the partitioning item’s key and the right scan for items with
	 * key less than or equal to the partitioning item’s key, as in
	 * 
	 * mergesort and shellshort are typically slower than quicksort because they
	 * also do data movement within their inner loops.
	 * 
	 * Improvements: insertion sort - for small ranges (why ? Quicksort is
	 * slower than insertion sort for tiny subarrays.)
	 * 
	 * Median-of-three partitioning.
	 * 
	 * first 3 way quicksort was slower - but a better quick 3 way was developed that is faster than mergesort for inputs with many duplicates
	 * 
	 * @param ar
	 * @param v
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(Comparable[] ar, int lo, int hi) {
		Comparable v = ar[lo];
		int i = lo + 1;
		int j = hi;
		while (i <= j) {
			while (i < hi && less(ar[i], v))
				i++;
			while (j > lo && less(v, ar[j]))
				j--;
			if (i >= j)
				break;
			swap(ar, i, j);
		}
		swap(ar, lo, j);
		return j;
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
