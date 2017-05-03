package apractice2.sort;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InsertionSort {
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
	 * Performance worse case: (N^2) / 2
	 * 
	 * Typical: (N^2) / 4
	 * 
	 * the running time is INPUT DEPENDENT
	 * if the arrays is (partially)sorted - MUCH FASTER THAN ANY SORT - LINEAR
	 * 
	 * 
	 * QUADRATIC - for non-distinct - all same values 
	 * 
	 * @param ar
	 */
	public static void sort(Comparable[] ar) {
		for(int i = 1; i < ar.length; i++){
			int j = i;
			Comparable v = ar[i];
			while( j>0 && less(v,ar[j-1])){
				ar[j]=ar[j-1];
				j--;
			}
			ar[j]=v;
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

}
